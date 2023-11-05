package com.codewithsiva.model;

public class Cart {
    private int id;
    private int userId;
    private int count;

    public Cart(int id, int userId, int count, Product product) {
        this.id = id;
        this.userId = userId;
        this.count = count;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;


}
