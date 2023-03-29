package Utils;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie findCookie(String name, Cookie[] cookies){
        if(name==null||cookies==null||cookies.length==0){
            return null;
        }

        for(Cookie c:cookies){
            if(name.equals(c.getName())){
                return c;
            }
        }
        return null;
    }
}
