package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest rep, HttpServletResponse resp) throws IOException {
        //创建或获取session会话对象
        HttpSession session = rep.getSession();
        //判断当前对话是否是新创建的
        boolean isNew=session.isNew();
        //获取session会话的唯一标识id
        String id=session.getId();

        resp.getWriter().write("得到的session的id是：" + id+"<br>");
        resp.getWriter().write("得到的session是否是新创建的："+isNew+"<br>");
    }

    //在session域中存数据
    protected void setAttribute(HttpServletRequest req,HttpServletResponse resq) throws IOException {
        req.getSession().setAttribute("key1","value1");
        resq.getWriter().write("数据已保存在session域中。");
    }

    //取session域中的数据
    protected void getAttribute(HttpServletRequest rep,HttpServletResponse resp) throws IOException {
        Object attribute = rep.getSession().getAttribute("key1");
        resp.getWriter().write("从session中取出的key1的值是："+attribute);
    }

    protected void defaultLife(HttpServletRequest rep, HttpServletResponse resp) throws IOException {
        //获取session的默认超时时长
        int maxInactiveInterval = rep.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长："+maxInactiveInterval+"秒");
    }

    protected void life3(HttpServletRequest rep, HttpServletResponse resp) throws IOException {
        //获取session对象
        HttpSession session= rep.getSession();
        //设置当前session3秒后超市
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("设置了session在3秒后超时。");
    }

    protected void deleteNow(HttpServletRequest rep, HttpServletResponse resp) throws IOException {
        //获取session对象
        HttpSession session= rep.getSession();
        //设置session会话立刻超时
        session.invalidate();
        resp.getWriter().write("session设置超时，已销毁。");
    }

}
