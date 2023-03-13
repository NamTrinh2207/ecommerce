package com.example.casenhom3.model;

public class Product {
    private Long id;
    private String productCode;
    private double productPrice;
    private String productImage;
    private String productDescribe;
    private Categories productCategories;


    public Product(Long id, String productCode, double productPrice, String productImage, String productDescribe, Categories productCategories) {
        this.id = id;
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescribe = productDescribe;
        this.productCategories = productCategories;
    }

    public Product(String productCode, double productPrice, String productImage, String productDescribe, Categories productCategories) {
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescribe = productDescribe;
        this.productCategories = productCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public Categories getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(Categories productCategories) {
        this.productCategories = productCategories;
    }
}
