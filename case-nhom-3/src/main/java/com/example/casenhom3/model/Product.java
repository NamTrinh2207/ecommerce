package com.example.casenhom3.model;

public class Product {
    private long id;
    private String code;

    private String name;

    private double price;
    private String img;
    private String describe;

    public Product() {
    }

    public Product(long id, String code,String name, double price, String img, String describe) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.img = img;
        this.describe = describe;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
