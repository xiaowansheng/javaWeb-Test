package com.bookMall.service.impl;

import com.bookMall.dao.BookDao;
import com.bookMall.dao.impl.BookDaoImpl;
import com.bookMall.pojo.Book;
import com.bookMall.pojo.Page;
import com.bookMall.service.BookService;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> queryForPage(int pageNo, int pageSize) {
        Page<Book> page=new Page<>();
        page.setDataTotal(bookDao.queryForPageTotal());
        int pageTotal=page.getDataTotal()%pageSize==0?page.getDataTotal()/pageSize:page.getDataTotal()/pageSize+1;
        page.setPageTotal(pageTotal);
        page.setDataList(bookDao.queryForPageItems(pageNo-1,pageSize));
        page.setPageNo(pageNo);
        return page;
    }

    @Override
    public int queryTotalForPrice(BigDecimal begin, BigDecimal end) {
        return queryTotalForPrice(begin,end);
    }

    @Override
    public Page<Book> queryBooksForPrice(int begin, int end, int pageNo, int pageSize) {
        Page<Book> page=new Page<>();
        page.setDataTotal(bookDao.queryTotalForPrice(begin,end));
        int pageTotal=page.getDataTotal()%pageSize==0?page.getDataTotal()/pageSize:page.getDataTotal()/pageSize+1;
        page.setPageTotal(pageTotal);
        page.setDataList(bookDao.queryForPriceItems(begin,end,pageNo,pageSize));
        page.setPageNo(pageNo);
        return page;
    }


}
