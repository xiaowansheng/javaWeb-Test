package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、getRequestURI()
        System.out.println("URI="+req.getRequestURI());
        //2、getRequestURL()
        System.out.println("URL="+req.getRequestURL());
        //3、getRemoteHost()
        System.out.println("客户端ip="+req.getRemoteHost());
        //4、getHeader()
        System.out.println("请求头User-agent="+req.getHeader("User-agent"));
        //5、getMethod()
        System.out.println("请求的方式="+req.getMethod());
    }
}
