package com.bookMall.service.impl;

import com.bookMall.dao.BookDao;
import com.bookMall.dao.UserDao;
import com.bookMall.dao.impl.BookDaoImpl;
import com.bookMall.dao.impl.UserDaoImpl;
import com.bookMall.pojo.Book;
import com.bookMall.pojo.Cart;
import com.bookMall.pojo.Item;
import com.bookMall.pojo.User;
import com.bookMall.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();
    private BookDao bookDao=new BookDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsername(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }

    @Override
    public Cart getCart() {
        return new Cart();
    }

    @Override
    public void addItem(Cart cart, Item item) {
        cart.addItem(item);
    }

    @Override
    public void addItemForId(Cart cart, Integer id) {
        cart.addItemForId(id);
    }

    @Override
    public void decrease(Cart cart, Integer id) {
        cart.decrease(id);
    }

    @Override
    public void undateNumber(Cart cart, Integer id, Integer number) {
        cart.updateNumber(id,number);
    }

    @Override
    public void clearCart(Cart cart) {
        cart.clear();
    }

    @Override
    public Item getItemForId(Integer id) {
        Book book=bookDao.queryBookById(id);
        Item item=new Item(id,book.getName(),1,book.getPrice());
        return item;
    }

    @Override
    public void deleteItem(Cart cart, Integer id) {
        if(cart.getItems().get(id)!=null){
            cart.deleteItem(id);
        }
    }

    @Override
    public Integer queryForUserId(String username) {
        return userDao.queryForUserId(username);
    }

}
