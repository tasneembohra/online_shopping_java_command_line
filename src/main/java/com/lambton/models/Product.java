package com.lambton.models;

import com.google.gson.annotations.SerializedName;
import com.lambton.utils.IDisplay;

public class Product implements IDisplay {
    @SerializedName("id")
    private int productId;
    @SerializedName("name")
    private String productName;
    @SerializedName("price")
    private double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String display() {
        return "\n\r\tProduct ID: " + productId
                + "\n\tProduct Name: " + productName
                + "\n\tPrice for unit: " + productPrice;
    }
}
