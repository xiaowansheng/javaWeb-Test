package com.bookMall.test;

import com.bookMall.dao.BookDao;
import com.bookMall.dao.impl.BookDaoImpl;
import com.bookMall.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private BookDao bookDao=new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"大家为什么这么帅？","大众",new BigDecimal(9.9),999,11,null));
    }

    @Test
    public void deleteBookById() {
        for(int i=1;i<22;i++){
            bookDao.deleteBookById(i);
        }
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"憨批！","我自己",new BigDecimal(9.9),999,11,null));
    }

    @Test
    public void queryBookById() {
        Book book=bookDao.queryBookById(22);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> list=bookDao.queryBooks();
        for (Book b:list) {
            System.out.println(b);
        }
    }
}