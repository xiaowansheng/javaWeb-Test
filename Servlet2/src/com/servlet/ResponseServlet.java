package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取默认字符集
        //System.out.println(resp.getCharacterEncoding());//默认：ISO-8859-1

        /*
        //设置服务器字符集
        resp.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器使用UTF-8字符集解码
        resp.setHeader("Content-type","text/html;Charset=UTF-8");
        */

        //这条语句会同时设置服务器和浏览器的字符集为UTF-8，还设置了响应头
        //此方法一定要在获取流对象之前调用有效
        resp.setContentType("text/html;Charset=UTF-8");

        //往客户端回传 字符串 数据
        PrintWriter printWriter = resp.getWriter();
        //中文乱码
        printWriter.write("这是一条响应消息。");
        printWriter.write("Hello World!");
    }
}
