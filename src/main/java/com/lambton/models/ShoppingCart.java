package com.lambton.models;

import com.lambton.utils.IDisplay;
import com.lambton.utils.TextFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class ShoppingCart implements IDisplay {
    private int cartId;
    private Date dateAdded;
    private Customer customer;
    private ArrayList<OrderedProduct> products = new ArrayList<>();

    public ShoppingCart(int cartId, Customer customer) {
        this.cartId = cartId;
        dateAdded = new GregorianCalendar().getTime();
        this.customer = customer;
    }

    public ArrayList<OrderedProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<OrderedProduct> products) {
        this.products = products;
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

    public void addProduct(Product product, int quantity) {
        OrderedProduct orderedProduct = new OrderedProduct(product, quantity);
        products.add(orderedProduct);
    }

    public void updateQuiantityForProduct(Product product, int quantity) {
        products.get(products.indexOf(product)).setQuantity(quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void viewCartDetails() {
        for (OrderedProduct orderedProduct : products) {
            System.out.println("Product name: " + orderedProduct.getProduct().getProductName()
                    + "\nPrice for unit: " + TextFormatter.currency(orderedProduct.getProduct().getProductPrice())
                    + "\nQuantity: " + orderedProduct.getQuantity());
        }
    }

    public Order checkOut() {
        return new Order(this);
    }

    @Override
    public String display() {
        return "\nCart ID: " + cartId
                + "\nDate Added: " + dateAdded
                + "\nCustomer Name: " + customer.getCustomerName();
    }
}
