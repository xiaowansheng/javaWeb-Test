package com.bookMall.test;

import com.bookMall.dao.OrderDao;
import com.bookMall.dao.impl.OrderDaoImpl;
import com.bookMall.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    private OrderDao orderDao=new OrderDaoImpl();

    @Test
    public void queryForOrderId() {
        System.out.println(orderDao.queryForOrderId("2020082118431234"));
    }

    @Test
    public void queryForOrders() {
        List<Order> orders=orderDao.queryForOrders();
        for(Order o:orders){
            System.out.println(o);
        }
    }

    @Test
    public void queryOrdersByUserId() {
        System.out.println(orderDao.queryOrdersByUserId(1));
    }

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("2020082118431234",new Date(),new BigDecimal(200),0,1));
    }

    @Test
    public void changeStatus() {
        orderDao.changeStatus("2020082118431234",2);
    }

    @Test
    public void deleteOrder() {
        orderDao.deleteOrder("2020");
    }
}