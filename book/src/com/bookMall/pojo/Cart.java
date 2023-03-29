package com.bookMall.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//购物车
public class Cart {
    private Map<Integer,Item> items=new HashMap<>();//商品集合
    private int itemToital;//商品总数
    private BigDecimal totalPrice=new BigDecimal(0);//商品总价

    public Cart() {
    }

    public Cart(Map<Integer, Item> items, int itemTotal, BigDecimal totalPrice) {
        this.items = items;
        this.itemToital = itemTotal;
        this.totalPrice = totalPrice;
    }

    public void updateData(){
        int count=0;
        BigDecimal newTotal=new BigDecimal(0);
        for (Map.Entry<Integer,Item> map:items.entrySet()) {
            count+=map.getValue().getNumber();
            newTotal=newTotal.add(map.getValue().getPrice().multiply(new BigDecimal(map.getValue().getNumber())));
        }
        itemToital=count;
        totalPrice=newTotal;
    }

    public void updateNumber(Integer id,Integer number){
        Item item=items.get(id);
        if(item!=null){
            if(number>0){
                item.setNumber(number);
            }
            else{
                items.remove(id);
            }
        }
        updateData();
    }

    /**
     * 添加某个商品到购物车
     * @param item
     */
    public void addItem(Item item){
        Item temp=items.get(item.getId());
        if(temp!=null){
            temp.setNumber(temp.getNumber()+1);
        }else{
            items.put(item.getId(),item);
        }
        updateData();
    }


    public void addItemForId(Integer id){
        Item item=items.get(id);
        if(item!=null) {
            item.setNumber(item.getNumber() + 1);
        }
        updateData();
    }

    /**
     * 根据商品Id，减少购物车中商品数量(-1)
     * @param id
     */
    public void decrease(Integer id){
        Item temp=items.get(id);
        if(temp!=null){
            temp.setNumber(temp.getNumber()-1);
//            temp.setTotalPrice(temp.getTotalPrice().subtract(temp.getPrice()));
        }
        if(temp.getNumber()<=0){
            items.remove(id);
        }
        updateData();
    }

    /**
     * 删除购物车中某个商品
     * @param id
     */
    public void deleteItem(Integer id){
        Item temp=items.get(id);
        if(temp!=null){
            items.remove(id);
        }
        updateData();
    }

    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();
        itemToital=0;
        totalPrice=new BigDecimal(0);
    }


    public Map<Integer, Item> getItems() {
        return items;
    }

    public int getItemTotal() {
        return itemToital;
    }

    public void setItemTotal(int itemToital) {
        this.itemToital = itemToital;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
