package down;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("有文件传过来了。");
//        ServletInputStream inputStream = request.getInputStream();
//        byte[] b=new byte[2048000];
//        int count=0;
//        count=inputStream.read(b);
//        System.out.println(new String(b,0,count));
        //1、先判断数据是否是多段数据（只有多段数据才是文件上传）
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断每一个表单项是普通类型，还是上传文件
                for(FileItem f:list){
                    if(f.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性："+f.getFieldName());
                        //参数utf-8解决乱码问题
                        System.out.println("表单项的value属性："+f.getString("UTF-8"));
                    }
                    else {
                        //上传文件
                        System.out.println("表单项的name属性值:"+f.getFieldName());
                        System.out.println("上传的文件名："+f.getName());
                        f.write(new File("E:\\临时文件\\"+f.getName()));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
