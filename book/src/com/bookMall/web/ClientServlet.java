package com.bookMall.web;

import com.bookMall.dao.UserDao;
import com.bookMall.dao.impl.UserDaoImpl;
import com.bookMall.pojo.Book;
import com.bookMall.pojo.Cart;
import com.bookMall.pojo.Item;
import com.bookMall.pojo.Page;
import com.bookMall.service.BookService;
import com.bookMall.service.UserService;
import com.bookMall.service.impl.BookServiceImpl;
import com.bookMall.service.impl.UserServiceImpl;
import com.mysql.cj.xdevapi.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

public class ClientServlet extends BaseServlet {
    private BookService bookService=new BookServiceImpl();
    private UserService userService=new UserServiceImpl();


    /**
     * 传入session，在session中获取或创建购物车
     * @param session
     * @return
     */
    public Cart getCart(HttpSession session){
        Cart cart=(Cart)session.getAttribute("cart");
        if(cart==null){
            cart=userService.getCart();
            session.setAttribute("cart",cart);
        }
        return cart;
    }

    public void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
//        if(session.getAttribute("username")==null){
////            request.getRequestDispatcher("/userServlet?action=login").forward(request,response);
//            response.sendRedirect(request.getContextPath()+"/page/user/login.jsp");
//            return;
//        }
        Cart cart=getCart(session);
        Integer id=Integer.parseInt(request.getParameter("id"));
        //Item item=userService.getItemForId(id);
//        String name=(String)request.getAttribute("name");
//        BigDecimal price=new BigDecimal((String)request.getAttribute("price"));
//        Item item=new Item(id,name,1,price);
        System.out.println(id);
        Item item=userService.getItemForId(id);
        cart.addItem(item);
        //获取头部request.getHeader("Referer")
        //跳转到原页面
        response.sendRedirect(request.getHeader("Referer"));
    }


    public void addItemForId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
//        if(session.getAttribute("username")==null){
////            request.getRequestDispatcher("/userServlet?action=login").forward(request,response);
//            response.sendRedirect(request.getContextPath()+"/page/user/login.jsp");
//            return;
//        }
        Cart cart=getCart(session);
        Integer id=Integer.parseInt(request.getParameter("id"));
        userService.addItemForId(cart,id);
        response.sendRedirect(request.getContextPath()+"/client/clientServlet?action=shoppingCart");
    }

    public void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session=request.getSession();
//        if(session.getAttribute("username")==null){
////            request.getRequestDispatcher("/userServlet?action=login").forward(request,response);
//            response.sendRedirect(request.getContextPath()+"/page/user/login.jsp");
//            return;
//        }
        Cart cart=getCart(session);
        userService.clearCart(cart);
        response.sendRedirect(request.getContextPath()+"/client/clientServlet?action=shoppingCart");
    }

    public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session=request.getSession();
//        if(session.getAttribute("username")==null){
//            response.sendRedirect(request.getContextPath()+"/page/user/login.jsp");
//            return;
//        }
        Cart cart=getCart(session);
        Integer id=Integer.parseInt(request.getParameter("id"));
        userService.deleteItem(cart,id);
        response.sendRedirect(request.getContextPath()+"/client/clientServlet?action=shoppingCart");
    }

    public void shoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
//        if(session.getAttribute("username")==null){
//            response.sendRedirect(request.getContextPath()+"/page/user/login.jsp");
//            return;
//        }
        Cart cart=getCart(session);
//        response.sendRedirect(request.getContextPath()+"/page/user/shoppingCart.jsp");
        request.getRequestDispatcher("/page/manager/shoppingCart.jsp").forward(request,response);
    }
}
