package com.bookMall.dao;

import com.bookMall.pojo.Item;
import com.bookMall.pojo.OrderItem;

import java.util.List;
import java.util.Map;

public interface OrderItemDao {
    /**
     * 根据订单项id查询订单项
     * @return
     */
    public OrderItem queryOrderItemById(Integer id);

    /**
     * 查询所有订单项
     * @return
     */
    public List<OrderItem> queryForOrderItems();

    /**
     * 根据订单id查询订单项
     * @param orderId
     * @return
     */
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);

    /**
     * 保存订单项，并根据订单修改销售情况
     * @param orderItem 订单项
     * @param bookId 商品id
     */
    public void saveOrderItem(OrderItem orderItem,Integer bookId);

    /**
     * 根据订单项集合，保存所有订单项
     * @param items
     */
    public void saveOrderItems(Map<Integer, Item> items,String orderId);
}
