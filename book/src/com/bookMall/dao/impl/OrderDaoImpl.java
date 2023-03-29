package com.bookMall.dao.impl;

import com.bookMall.dao.OrderDao;
import com.bookMall.pojo.Order;

import java.text.SimpleDateFormat;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public Order queryForOrderId(String orderId) {
        String sql="select order_id orderId,create_time createTime,price,status,user_id userId from tb_order where order_id=?;";
        return queryForOne(Order.class,sql,orderId);
    }

    @Override
    public List<Order> queryForOrders() {
        String sql="select order_id orderId,create_time createTime,price,status,user_id userId from tb_order;";
        return queryForList(Order.class,sql);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql="select order_id orderId,create_time createTime,price,status,user_id userId from tb_order where user_id=?;";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public void saveOrder(Order order) {
        String sql="insert into tb_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?);";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        update(sql,order.getOrderId(),simpleDateFormat.format(order.getCreateTime()),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public void changeStatus(String orderId, Integer status) {
        String sql="update tb_order set status=? where order_id=?;";
        update(sql,status,orderId);
    }

    @Override
    public void deleteOrder(String orderId) {
        String sql="delete from tb_order where order_id=?;";
        update(sql,orderId);
    }
}
