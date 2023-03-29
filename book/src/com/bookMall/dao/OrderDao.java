package com.bookMall.dao;

import com.bookMall.pojo.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 查询订单
     * @return
     */
    public Order queryForOrderId(String orderId);

    /**
     * 查询所有的订单
     * @return
     */
    public List<Order> queryForOrders();

    /**
     * 根据用户id查询用户的订单
     * @param userId
     * @return
     */
    public List<Order> queryOrdersByUserId(Integer userId);

    /**
     * 保存订单
     * @param order
     */
    public void saveOrder(Order order);

    /**
     * 修改订单状态
     * @param orderId
     * @param status 0：未发货，1：已发货，2：已签收
     */
    public void changeStatus(String orderId,Integer status);

    /**
     * 根据订单号，删除订单
     * @param orderId
     */
    public void deleteOrder(String orderId);
}
