package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("用户名："+username);
        req.setAttribute("key","请求通过");
        System.out.println("servlet1处理完。");
        //存储转发
        //转发的地址
        /*
        *  请求转发必须以斜杠开头，斜杠表示地址：http://ip:port/工程名/   ，映射到IDEA代码的web目录
        * */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        //转向
        requestDispatcher.forward(req,resp);
    }
}
