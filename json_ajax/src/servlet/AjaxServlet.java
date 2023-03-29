package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet{
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Ajax请求来了。");
        String json = "{\"name\":\"憨憨\",\"sex\":\"男\",\"age\":20}";
        resp.getWriter().write(json);
    }

    protected void jqueryAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("jqueryAjax请求来了。");
        String json = "{\"name\":\"憨憨\",\"sex\":\"男\",\"age\":20}";
        resp.getWriter().write(json);
    }
}
