package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext类的四个作用
//        1、获取web.xml中上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username=context.getInitParameter("username");
        System.out.println("参数username的值是："+username);
        System.out.println("参数password的值是："+context.getInitParameter("password"));
//        2、获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径："+context.getContextPath());
//        3、获取工程部署后在服务器硬盘上的绝对路径
        /*
        *   /被服务器解析地址为：http://ip:port/工程名/
        * */
        System.out.println("工程部署的路径："+context.getRealPath("/"));
//        4、像Map一样存储数据
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
