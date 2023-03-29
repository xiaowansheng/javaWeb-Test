package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求体的字符集为UTF-8，从而解决post请求乱码问题
        //必须写在第一行才会生效
        request.setCharacterEncoding("UTF-8");
        System.out.println("--------doPost---------");
        String username = request.getParameter("username");
        System.out.println("用户名=" + username);
        String password = request.getParameter("password");
        System.out.println("用户密码=" + password);
        String[] hobby = request.getParameterValues("hobby");
        System.out.println("爱好="+ Arrays.asList(hobby));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--------doGet----------");
        String username = request.getParameter("username");
        System.out.println("用户名=" + username);
        String password = request.getParameter("password");
        System.out.println("用户密码=" + password);
        String[] hobby = request.getParameterValues("hobby");
        System.out.print("爱好=");
        for (String h : hobby) {
            System.out.print(h + " ");
        }
    }
}
