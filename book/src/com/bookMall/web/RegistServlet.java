package com.bookMall.web;

import com.bookMall.pojo.User;
import com.bookMall.service.UserService;
import com.bookMall.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("注册请求。");
        //1、获取请求参数
        String username=request.getParameter("username");//用户名
        String password=request.getParameter("password");//密码
        String email=request.getParameter("email");//邮箱
        String verificatiionCode=request.getParameter("verificatiionCode");//验证码
        //2、检查验证码是否正确
        if("1234".equalsIgnoreCase(verificatiionCode)){
            //3、检查用户名是否可用
            if(!userService.existUsername(username)){
                //可用
                //调用service保存到数据库
                userService.registUser(new User(null,username,password,email));
                System.out.println("注册成功！");
                request.getRequestDispatcher("/page/register-success.jsp").forward(request,response);
            }else{
                System.out.println("用户名已存在。");
                request.setAttribute("msg","用户名已存在。");
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                request.setAttribute("email",email);
                //跳转注册页面
                request.getRequestDispatcher("/page/register.jsp").forward(request,response);
            }
        }else {
            //不正确
            System.out.println("验证码["+verificatiionCode+"]错误.");
            request.setAttribute("msg","验证码错误。");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("email",email);
            //页面跳回注册页面
            request.getRequestDispatcher("/page/register.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
