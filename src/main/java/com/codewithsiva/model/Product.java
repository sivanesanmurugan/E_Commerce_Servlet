package com.codewithsiva.model;

public class Product {
    private int id;
    private String title;
    private double price;
    private String image;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }


}

