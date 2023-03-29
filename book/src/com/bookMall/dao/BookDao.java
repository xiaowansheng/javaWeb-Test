package com.bookMall.dao;

import com.bookMall.pojo.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public int queryForPageTotal();

    public List<Book> queryForPageItems(int pageNo,int pageSize);

    public int queryTotalForPrice(int begin,int end);

    public List<Book> queryForPriceItems(int begin,int end,int pageNo,int pageSize);
}
