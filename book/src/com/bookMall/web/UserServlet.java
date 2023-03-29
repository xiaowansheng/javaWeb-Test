package com.bookMall.web;

import com.bookMall.pojo.Book;
import com.bookMall.pojo.Page;
import com.bookMall.pojo.User;
import com.bookMall.service.BookService;
import com.bookMall.service.UserService;
import com.bookMall.service.impl.BookServiceImpl;
import com.bookMall.service.impl.UserServiceImpl;
import com.bookMall.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService=new UserServiceImpl();
    private BookService bookService=new BookServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //2、调用xxxService处理业务
        if(userService.login(new User(null,username,password,null))!=null){
            System.out.println("登录成功！");
            request.getSession().setAttribute("username",username);
            Integer userId=userService.queryForUserId(username);
            request.getSession().setAttribute("userId",userId);
            request.getSession().setAttribute("cart",userService.getCart());
//            request.getRequestDispatcher("page/user/login-success.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath());
        }else {
            System.out.println("登录失败。");
            //登录失败回写信息
            request.setAttribute("msg","用户名或密码错误。");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.getRequestDispatcher("page/user/login.jsp").forward(request,response);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //注销用户
        request.getSession().invalidate();
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath());
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("注册请求。");
        //1、获取请求参数
        String username=request.getParameter("username");//用户名
        String password=request.getParameter("password");//密码
        String email=request.getParameter("email");//邮箱
        String verificatiionCode=request.getParameter("verificatiionCode");//验证码
        String kaptcha=(String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //2、检查验证码是否正确
        if(kaptcha!=null&&kaptcha.equalsIgnoreCase(verificatiionCode)){
            //3、检查用户名是否可用
            if(!userService.existUsername(username)){
                //可用
                //调用service保存到数据库
                User user =new User();
                WebUtils.copyParameterBean(request.getParameterMap(),user);
                userService.registUser(user);
                System.out.println("注册成功！");
//                request.getRequestDispatcher("/page/register-success.jsp").forward(request,response);
                response.sendRedirect(request.getContextPath()+"/page/user/register-success.jsp");
            }else{
                System.out.println("用户名已存在。");
                request.setAttribute("msg","用户名已存在。");
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                request.setAttribute("email",email);
                //跳转注册页面
                request.getRequestDispatcher("/page/user/register.jsp").forward(request,response);
            }
        }else {
            //不正确
            System.out.println("验证码["+verificatiionCode+"]错误.");
            request.setAttribute("msg","验证码错误。");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("email",email);
            //页面跳回注册页面
            request.getRequestDispatcher("/page/user/register.jsp").forward(request,response);
        }

    }

    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int pageNo=1;
        int pageSize=4;
        String pageNoStr=request.getParameter("pageNo");
        if(pageNoStr!=null&&!"".equals(pageNoStr)){
            pageNo=Integer.parseInt(pageNoStr);
        }
        String pageSizeStr=request.getParameter("pageSize");
        if(pageSizeStr!=null&&!"".equals(pageSizeStr)){
            pageSize=Integer.parseInt(pageSizeStr);
        }
        Page<Book> page=bookService.queryForPage(pageNo,pageSize);
        page.setUrl("userServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/page/client/index.jsp").forward(request,response);
    }

    public void pageForPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int pageNo=1;
        int pageSize=4;
        int begin=0;
        int end=Integer.MAX_VALUE;
        String beginStr=request.getParameter("begin");
        String endPrice=request.getParameter("end");
        if((endPrice==null||"".equals(endPrice))&&(beginStr==null||"".equals(beginStr))){
            page(request,response);
            return;
        }
        StringBuilder sb=new StringBuilder("userServlet?action=pageForPrice");
        String pageNoStr=request.getParameter("pageNo");
        if(pageNoStr!=null&&!"".equals(pageNoStr)){
            pageNo=Integer.parseInt(pageNoStr);
        }
        String pageSizeStr=request.getParameter("pageSize");
        if(pageSizeStr!=null&&!"".equals(pageSizeStr)){
            pageSize=Integer.parseInt(pageSizeStr);
        }
        if(beginStr!=null&&!"".equals(beginStr)){
            sb.append("&begin="+beginStr);
            begin=Integer.parseInt(beginStr);
        }
        if(endPrice!=null&&!"".equals(endPrice)){
            sb.append("&end="+endPrice);
            end=Integer.parseInt(endPrice);
        }
        request.setAttribute("begin",begin);
        request.setAttribute("end",end);
        Page<Book> page=bookService.queryBooksForPrice(begin,end,pageNo,pageSize);
        page.setUrl(sb.toString());
        request.setAttribute("page",page);
        request.getRequestDispatcher("/page/client/index.jsp").forward(request,response);
    }
}
