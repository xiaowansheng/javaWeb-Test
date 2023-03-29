package com.bookMall.service;

import com.bookMall.pojo.Cart;
import com.bookMall.pojo.Order;
import com.bookMall.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    /**
     * 根据购物车结算，生成订单
     * @param cart
     */
    public String createOrder(Cart cart,Integer userId);

    /**
     * 根据订单号，查询订单内的所有订单项
     * @param orderId
     */
    public List<OrderItem> showOrderItemsByOrderId(String orderId);

    /**
     * 根据订单Id查询订单
     * @param orderId
     * @return
     */
    public Order queryOrderByOrderId(String orderId);

    /**
     * 根据用户id，查询该用户所有订单
     * @param userId
     * @return
     */
    public List<Order> showOrdersByUserId(Integer userId);

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> showOrders();

    /**
     * 根据订单号删除订单
     * @param orderId
     */
    public void deleteOrder(String orderId);

    /**
     * 根据订单号，签收订单,即确认收货
     * @param orderId
     */
    public void receiveOrder(String orderId);

    /**
     * 根据订单号，修改订单状态
     * @param orderId
     * @param status
     */
    public void updateStatus(String orderId,Integer status);
}
