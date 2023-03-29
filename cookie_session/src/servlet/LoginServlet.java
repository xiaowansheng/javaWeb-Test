package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if("1234".equals(username)&&"1234".equals(password)){
            System.out.println("登录成功！");
            Cookie cookie=new Cookie("username",username);
            cookie.setMaxAge(3600);//保存一小时
            resp.addCookie(cookie);
        }else {
            System.out.println("登陆失败！");
        }
    }
}
