package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看参数
        String username=req.getParameter("username");
        System.out.println("用户名："+username);

        //查看servlet1的标记
        Object key=req.getAttribute("key");
        System.out.println("来自servlet的标记："+key);

        //处理自己业务
        System.out.println("处理自己servlet2的业务");
    }
}
