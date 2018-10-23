package com.lambton.models;

import com.google.gson.annotations.SerializedName;

public class OrderedProduct {
    @SerializedName("product")
    private Product product;

    @SerializedName("quantity")
    private int quantity;

    public OrderedProduct(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double calculatePrice() {
        return product.getProductPrice() * quantity;
    }
}
