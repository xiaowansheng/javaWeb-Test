package com.bookMall.pojo;

import java.math.BigDecimal;

//商品
public class Item {
    private Integer id;//商品Id
    private String name;//商品名称
    private Integer number;//商品数量
    private BigDecimal price;//商品单价
//    private BigDecimal totalPrice;//商品总价,默认等于单价

    public Item() {
    }

    public Item(Integer id, String name, Integer number, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public BigDecimal getTotalPrice(){
        return new BigDecimal(number).multiply(price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    public void setTotalPrice(BigDecimal totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
//                ", totalPrice=" + totalPrice +
                '}';
    }
}
