package com.shooksweb.model;

public class Product {
    private String productId;
    private String name;
    private Double price;
    private Double comparePrice;
    private String productImage;

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getComparePrice() {
        return comparePrice;
    }

    public void setComparePrice(Double comparePrice) {
        this.comparePrice = comparePrice;
    }
}
