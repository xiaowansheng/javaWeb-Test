package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    /*重写init(ServletConfig config)要先调用父类的init(ServletConfig config)方法来保存config对象*/
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * doGet()在get请求的时候调用
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了偶doGet方法");
    }

    /**
     * doPost()在post请求的时候调用
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了doPost方法");
    }
}
