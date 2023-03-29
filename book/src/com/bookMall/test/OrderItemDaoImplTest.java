package com.bookMall.test;

import com.bookMall.dao.OrderItemDao;
import com.bookMall.dao.impl.OrderItemDaoImpl;
import com.bookMall.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();

    @Test
    public void queryOrderItemById() {
        System.out.println(orderItemDao.queryOrderItemById(1));

    }

    @Test
    public void queryForOrderItems() {
        List<OrderItem> orderItems=orderItemDao.queryForOrderItems();
        for(OrderItem o:orderItems){
            System.out.println(o);
        }
    }

    @Test
    public void queryOrderItemsByOrderId() {
        System.out.println(orderItemDao.queryOrderItemsByOrderId("2020082118431234"));
    }

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null,"数据结构",1,new BigDecimal(49.99),new BigDecimal(49.99),"2020082118431234"),null);
    }
}