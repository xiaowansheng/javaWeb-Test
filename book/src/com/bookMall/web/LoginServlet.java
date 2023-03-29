package com.bookMall.web;

import com.bookMall.pojo.User;
import com.bookMall.service.UserService;
import com.bookMall.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //2、调用xxxService处理业务
        if(userService.login(new User(null,username,password,null))!=null){
            System.out.println("登录成功！");
            request.getRequestDispatcher("page/login-success.jsp").forward(request,response);
        }else {
            System.out.println("登录失败。");
            //登录失败回写信息
            request.setAttribute("msg","用户名或密码错误。");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.getRequestDispatcher("page/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
