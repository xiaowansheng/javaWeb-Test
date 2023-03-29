package com.bookMall.dao.impl;

import com.bookMall.dao.OrderItemDao;
import com.bookMall.pojo.Item;
import com.bookMall.pojo.OrderItem;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public OrderItem queryOrderItemById(Integer id) {
        String sql="select id,name,count,price,total_price totalPrice,order_id orderId from tb_orderItem where id=?;";;
        return  queryForOne(OrderItem.class,sql,id);
    }

    @Override
    public List<OrderItem> queryForOrderItems() {
        String sql="select id,name,count,price,total_price totalPrice,order_id orderId from tb_orderItem;";
        return queryForList(OrderItem.class,sql);
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql="select id,name,count,price,total_price totalPrice,order_id orderId from tb_orderItem where order_id=?;";
        return queryForList(OrderItem.class,sql,orderId);
    }

    @Override
    public void saveOrderItem(OrderItem orderItem,Integer bookId) {
        String sql="insert into tb_orderItem(name,count,price,total_price,order_id) values(?,?,?,?,?);";
        update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
        sql="update tb_book set sales=sales+?,stock=stock-? where id=?;";
        update(sql,orderItem.getCount(),orderItem.getCount(),bookId);
    }

    @Override
    public void saveOrderItems(Map<Integer, Item> items,String orderId) {
        Set<Map.Entry<Integer,Item>> set=items.entrySet();
        OrderItem orderItem=null;
        Item item=new Item();
        for(Map.Entry<Integer,Item> m:set){
            item=m.getValue();
            orderItem=new OrderItem();
            orderItem.setId(null);
            orderItem.setName(item.getName());
            orderItem.setCount(item.getNumber());
            orderItem.setPrice(item.getPrice());
            orderItem.setTotalPrice(item.getTotalPrice());
            orderItem.setOrderId(orderId);
            saveOrderItem(orderItem,item.getId());
        }
    }
}
