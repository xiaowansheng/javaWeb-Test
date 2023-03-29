package com.bookMall.service;

import com.bookMall.pojo.Cart;
import com.bookMall.pojo.Item;
import com.bookMall.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 返回null则登录失败
     */
    public User login(User user);

    /**
     * 判断用户名是否存在
     * @param username
     * @return 存在则返回true
     */
    public boolean existUsername(String username);

    /**
     * 获取购物车
     * @return
     */
    public Cart getCart();

    /**
     * 在购物车中添加商品
     * @param cart 购物车
     * @param item 商品
     */
    public void addItem(Cart cart, Item item);

    /**
     * 根据id，让购物车中对应商品数量+1
     * @param cart
     * @param id
     */
    public void addItemForId(Cart cart,Integer id);

    /**
     * 根据商品id，减少物品数量
     * @param id
     */
    public void decrease(Cart cart,Integer id);

    /**
     * 根据id，修改购物车中商品数量
     * @param id
     * @param number
     */
    public void undateNumber(Cart cart,Integer id,Integer number);

    /**
     * 清空购物车
     * @param cart
     */
    public void clearCart(Cart cart);

    /**
     * 根据id获取商品对象
     * @param id
     * @return
     */
    public Item getItemForId(Integer id);

    /**
     * 根据id，删除购物车中商品
     * @param cart
     * @param id
     */
    public void deleteItem(Cart cart,Integer id);

    /**
     * 根据用户名查询用户Id
     * @param username
     * @return
     */
    public Integer queryForUserId(String username);
}
