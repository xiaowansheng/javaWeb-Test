package com.bookMall.service;

import com.bookMall.pojo.Book;
import com.bookMall.pojo.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    /**
     * 添加书籍
     * @param book
     */
    public void addBook(Book book);

    /**
     * 根据Id删除书籍
     * @param id
     */
    public void deleteBookById(Integer id);

    /**
     * 修改书籍信息
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 根据Id查询书籍信息
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询所有书籍信息
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 查询数据总数，当前页数据等数据，放入page类中返回
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> queryForPage(int pageNo, int pageSize);

    /**
     * 根据价格区间查询该区间段的商品总数
     * @param begin 开始区间
     * @param end 结束区间
     * @return 返回查询到的数目
     */
    public int queryTotalForPrice(BigDecimal begin,BigDecimal end);

    /**
     * 根据价格区间和页数，查询符合条件的该页数据
     * @param begin
     * @param end
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Book> queryBooksForPrice(int begin,int end,int pageNo,int pageSize);
}
