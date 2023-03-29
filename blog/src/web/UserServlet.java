package web;

import bean.User;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserServlet extends BaseServlet {
    public void login(HttpServletRequest req, HttpServletResponse resp){
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

    }
}
