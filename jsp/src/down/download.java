package down;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;


public class download extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取要下载的文件名
        String downloadFileName="图7.jpg";
        //2、读取要下载的文件内容（通过ServletContext对象可以读取）
        ServletContext servletContext=getServletContext();
        //获取要下载的文件类型
        String mimeType=servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型："+mimeType);
        //4、在回传前，通过响应头告诉客户端返回的数据类型
        //5、还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        // Content-Disposition响应头，表示收到的数据怎么处理
        //attachment表示附件，标属下载使用
        //filename表示下载的文件名
        //URL编码把汉字转换成%xx%xx的格式
        if(req.getHeader("User-Agent").contains("Firefox")){
            //如果是火狐使用Base64编码
            //resp.setHeader("Content-Disposition","attachment;fileName==？UTF-8?B?"+Base64.getEncoder().encode("图7.jpg".getBytes("UTF-8"))+"?=");
            resp.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode("图7.jpg","UTF-8"));
        }else {
            //如果是IE使用URL编码
            resp.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode("图7.jpg","UTF-8"));
        }

        InputStream resource = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取响应输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //3、把下载的文件内容回传给客户端
        //读取流中全部数据，赋值给输出流，回传给客户端
        IOUtils.copy(resource,outputStream);
    }
}
