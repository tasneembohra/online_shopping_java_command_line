package com.lambton.models;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ShoppingCart {
    private int cartId = 0;
    private Date dateAdded;
    private Customer customer;
    private HashMap<Product, Integer> cartMap = new HashMap<>(); //<productId, quantity>

    public ShoppingCart(Customer customer) {
        cartId++;
        dateAdded = new GregorianCalendar().getTime();
        this.customer = customer;
    }

    public int getCartId() {
        return cartId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public Customer getCustomer() {
        return customer;
    }

    public HashMap<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void addProduct(Product product, int quantity) {
        cartMap.put(product, quantity);
    }

    public void updateQuiantityForProduct(Product product, int quantity) {
        cartMap.put(product, quantity);
    }

    public void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public void viewCartDetails() {
        for (HashMap.Entry<Product, Integer> item: cartMap.entrySet()) {
            System.out.println("Product name: " + item.getKey().getProductName() + "\nQuantity: " + item.getValue());
        }
    }

    public Order checkOut() {
        return new Order(this);
    }
}
