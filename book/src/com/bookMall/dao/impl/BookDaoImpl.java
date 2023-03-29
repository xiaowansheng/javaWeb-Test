package com.bookMall.dao.impl;

import com.bookMall.dao.BookDao;
import com.bookMall.pojo.Book;
import com.bookMall.utils.JDBCUtils;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql="insert into tb_book(name, author , price, sales, stock , img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice().toString(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from tb_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update tb_book set name=?, author=?, price=? , sales=? , stock=? , img_path=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql="select id,name,author,price,sales,stock,img_path from tb_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select id,name,author,price,sales,stock,img_path from tb_book;";
        return queryForList(Book.class,sql);
    }

    @Override
    public int queryForPageTotal() {
        String sql="select count(id) dataTotal from tb_book;";
        return Integer.parseInt(queryForStringValue(sql).toString());
    }

    @Override
    public List<Book> queryForPageItems(int pageNo, int pageSize) {
        if(pageNo!=0){
            pageNo=pageNo*pageSize;
        }
        String sql="select id,name,author,price,sales,stock,img_path from tb_book limit ?,?;";
        return queryForList(Book.class,sql,pageNo,pageSize);
    }

    @Override
    public int queryTotalForPrice(int begin, int end) {
        String sql="select count(id) dataTotal from tb_book where price between ? and ?;";
        return Integer.parseInt(queryForStringValue(sql,begin,end).toString());
    }

    @Override
    public List<Book> queryForPriceItems(int begin, int end, int pageNo, int pageSize) {
        if(pageNo!=0){
            pageNo=pageNo*pageSize;
        }
        String sql="select id,name,author,price,sales,stock,img_path from tb_book where price between ? and ? limit ?,?;";
        return queryForList(Book.class,sql,begin,end,pageNo,pageSize);
    }
}
