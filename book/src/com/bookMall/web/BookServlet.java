package com.bookMall.web;

import com.bookMall.pojo.Book;
import com.bookMall.pojo.Page;
import com.bookMall.service.BookService;
import com.bookMall.service.impl.BookServiceImpl;
import com.bookMall.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookServlet extends BaseServlet {
    private BookService bookService=new BookServiceImpl();

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1、获取参数，封装成Book对象
        Book book=new Book();
        WebUtils.copyParameterBean(request.getParameterMap(),book);
        //2、调用BookService.addBook()保存书籍信息
        bookService.addBook(book);
        //3、跳转到图书管理页面
//        request.getRequestDispatcher("/manager/bookServlet?action=queryList").forward(request,response);//请求重定向有Bug,表单重复提交
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=queryList");
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1、获取参数Id
        String idStr=request.getParameter("id");
        Integer id=Integer.parseInt(idStr);
        //2、调用bookService.deleteBookById()删除该id对应书籍信息
        bookService.deleteBookById(id);
        //3、请求转发到原页面
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=queryList");
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Book book=new Book();
        WebUtils.copyParameterBean(request.getParameterMap(),book);
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=queryList");
    }

    public void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idStr=request.getParameter("id");
        Integer id=Integer.parseInt(idStr);
        Book book = bookService.queryBookById(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/page/manager/book/book-edit.jsp").forward(request,response);
    }

    public void queryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、通过BookService查询全部图书
        List<Book> list= bookService.queryBooks();
        //2、把全部图书保存到Request域中
        request.setAttribute("books",list);
        //3、请求转发到/page/manager/book-manage.jsp
        request.getRequestDispatcher("/page/manager/book/book-manage.jsp").forward(request,response);
    }

    //暂时没用
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String pageNoStr=request.getParameter("pageNo");
        int pageNo=0;
        if(pageNoStr!=null&&!"".equals(pageNoStr)){
            pageNo=Integer.parseInt(pageNoStr);
        }
        String pageSizeStr=request.getParameter("pageSize");
        int pageSize=4;
        if(pageSizeStr!=null&&"".equals(pageSizeStr)){
            pageSize=Integer.parseInt(pageSizeStr);
        }
        Page<Book> page=bookService.queryForPage(pageNo,pageSize);
//        page.setUrl("");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/page/manager/book-manage.jsp").forward(request,response);
    }
}
