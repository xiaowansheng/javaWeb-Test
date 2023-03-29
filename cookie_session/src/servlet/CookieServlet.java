package servlet;

import Utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    public void createCookie(HttpServletRequest rep, HttpServletResponse resp) throws IOException {
        System.out.println("cookie创建了！");
        //1、创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2、通知客户端保存
        resp.addCookie(cookie);
        //可以创建很多个
        Cookie cookie1=new Cookie("key2","value2");
        resp.addCookie(cookie1);

        resp.getWriter().write("cookie创建成功。");
    }

    public void getCookies(HttpServletRequest rep,HttpServletResponse resp) throws IOException {
        Cookie[] cookies=rep.getCookies();

        for(Cookie c:cookies){
            //getName返回cookie的name值
            //getValue返回cookie的Value值
            resp.getWriter().write("Cookie["+c.getName()+"="+c.getValue()+"]<br/>");
        }

        //获取某个cookie值
        Cookie cookie=CookieUtil.findCookie("key2",cookies);
        if(cookie==null){
            resp.getWriter().write("cookie值没有找到。");
        }
        else {
            resp.getWriter().write("cookie值找到了。");
        }
    }

    public void updateCookie(HttpServletRequest rep,HttpServletResponse resp) throws IOException {
        //方法一
        //1、新创建一个要修改的同名cookie值
        //2、在构造器中，同时赋予新cookie值
        Cookie cookie=new Cookie("key1","newValue");
        //3、调用resp.addCookie()
        resp.addCookie(cookie);
        resp.getWriter().write("cookie值已修改。");

        //方法二
        //1、先查找到需要修改的Cookie对象
        Cookie cookie1=CookieUtil.findCookie("key2",rep.getCookies());
        //2、使用setValue（）赋予新的value值
        cookie1.setValue("newValue");
        //3、调用resp.addCookie()通知客户端保存
        resp.addCookie(cookie1);
        resp.getWriter().write("cookie值已修改。");
    }

    public void defaultLife(HttpServletRequest rep,HttpServletResponse resp){
        Cookie cookie=new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }


    public void deleteNow(HttpServletRequest rep,HttpServletResponse resp) throws IOException {
        //先找到删除的cookie对象
        Cookie cookie=CookieUtil.findCookie("key1",rep.getCookies());
        //调用setMaxAge(0)
        if(cookie!=null){
            cookie.setMaxAge(0);//0表示马上删除，都不需要等待
            //调用reesp.addCookie()
            resp.addCookie(cookie);
            resp.getWriter().write("cookie名为key1的cookie已被删除。");
        }
    }

    public void life3600(HttpServletRequest rep,HttpServletResponse resp){
        Cookie cookie=new Cookie("life3600","life3600");
        cookie.setMaxAge(60*60);//设置cookie一小时后被删除，无效
        resp.addCookie(cookie);
    }
}