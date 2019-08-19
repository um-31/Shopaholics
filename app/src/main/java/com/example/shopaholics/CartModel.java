package com.example.shopaholics;

public class CartModel {
    String name;
    String price;

    public CartModel() {
    }

    public CartModel(String price, String name) {
        this.price = price;
        this.name = name;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
