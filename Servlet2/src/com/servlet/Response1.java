package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置浏览器服务器编码
        resp.setContentType("text/html;Charset=UTF-8");
        //发送消息
        //不会显示（会直接跳转到新地址）
        resp.getWriter().write("地址已经改了，请到新地址访问。");
        //控制台打印
        System.out.println("现在是在Response1");

        //方法（1）
        //设置响应状态码，表示重定向（已迁移）
        //resp.setStatus(302);
        //设置响应头，说明新的地址在哪
        //resp.setHeader("Location", "Http://127.0.0.1:8080/Servlet2/response2");

        //方法（2）
        //直接设置重定向
        resp.sendRedirect("http://127.0.0.1:8080/Servlet2/response2");
    }
}
