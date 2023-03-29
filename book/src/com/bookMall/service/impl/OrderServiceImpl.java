package com.bookMall.service.impl;

import com.bookMall.dao.OrderDao;
import com.bookMall.dao.OrderItemDao;
import com.bookMall.dao.impl.OrderDaoImpl;
import com.bookMall.dao.impl.OrderItemDaoImpl;
import com.bookMall.pojo.Cart;
import com.bookMall.pojo.Item;
import com.bookMall.pojo.Order;
import com.bookMall.pojo.OrderItem;
import com.bookMall.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    @Override
    public String createOrder(Cart cart,Integer userId) {
        Set<Map.Entry<Integer,Item>> items=cart.getItems().entrySet();
        Order order=new Order();
        order.setOrderId(new Date()+""+userId);
        order.setCreateTime(new Date());
        order.setPrice(cart.getTotalPrice());
        order.setStatus(0);
        order.setUserId(userId);
        orderDao.saveOrder(order);
        orderItemDao.saveOrderItems(cart.getItems(),order.getOrderId());
        return order.getOrderId();
    }

    @Override
    public List<OrderItem> showOrderItemsByOrderId(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public Order queryOrderByOrderId(String orderId) {
        return orderDao.queryForOrderId(orderId);
    }

    @Override
    public List<Order> showOrdersByUserId(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public List<Order> showOrders() {
        return orderDao.queryForOrders();
    }

    @Override
    public void deleteOrder(String orderId) {
        orderDao.deleteOrder(orderId);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeStatus(orderId,2);
    }

    @Override
    public void updateStatus(String orderId, Integer status) {
        orderDao.changeStatus(orderId,status);
    }
}
