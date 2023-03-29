package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.net.http.HttpRequest;

public class HelloServlet implements Servlet {
    //第一第二步实在第一次访问servlet程序时调用
    // 第三步每次访问都会调用
    //第四步销毁方法，在web工程停止时调用
    public HelloServlet() {
        System.out.println("第一步执行-构造方法。");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("第二步执行-init初始化方法");
        //1、可以获取Servlet程序的别名Servlet-name的值
        String servletName=servletConfig.getServletName();
        System.out.println("HelloServlet程序的别名:"+servletName);
        //2、获取初始化参数init-param
        String username = servletConfig.getInitParameter("username");
        System.out.println("username的值为：" + username);
        String url=servletConfig.getInitParameter("url");
        System.out.println("url的值为："+url);
        //3、获取ServletContext对象
        ServletContext servletContext=servletConfig.getServletContext();
        System.out.println("servletContext对象为："+servletContext);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service方法是专门用来处理请求和响应的（只要访问HelloServlet程序就会执行这个方法）
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("第三步执行-Service。");
        //System.out.println("HelloServlet被访问了！");
        //类型转换，转换成子类HttpServletRequest，有getMethod（）方法
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取请求方式
        String method=request.getMethod();
        //System.out.println(method);
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }

    /**
     * 做get请求的操作
     * */
    public void doGet(){
        System.out.println("Get请求。");
        System.out.println("Get请求。");
        System.out.println("Get请求。");
    }

    /**
     * 做Post请求的操作
     * */
    public void doPost(){
        System.out.println("Post请求。");
        System.out.println("Post请求。");
        System.out.println("Post请求。");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("第四步执行-销毁方法。");
    }
}
