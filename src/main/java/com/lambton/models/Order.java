package com.lambton.models;

import com.lambton.utils.IDisplay;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Order implements IDisplay {

    private int orderId = 0;
    private Date dateCreated;
    private Date dateShipped;
    private String status;
    private ShippingInfo shippingInfo;
    private HashMap<Product, Integer> orderMap;
    private Customer customer;
    private boolean orderConfirmation = false; //confirmation

    public Order(ShoppingCart shoppingCart) {
        orderId++;
        dateCreated = new GregorianCalendar().getTime();
        orderMap = shoppingCart.getCartMap();
        customer = shoppingCart.getCustomer();
        shippingInfo = customer.getShippingInfo();
    }

    public boolean isOrderConfirmation() {
        return orderConfirmation;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public String getCustomerName() {
        return customer.getCustomerName();
    }

    public int getCustomerId() {
        return customer.getUserId();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void updateShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public void setShippingType(String type) {
        shippingInfo.setShippingType(type);
    }

    public void calcShippingCost() {
        int productCount = 0;
        for (HashMap.Entry<Product, Integer> product: orderMap.entrySet()) {
            productCount += product.getValue();
        }
        if (productCount > 5) {
            shippingInfo.setShippingCost(shippingInfo.getShippingCost() * 1.5);
        } else if (productCount > 10) {
            shippingInfo.setShippingCost(shippingInfo.getShippingCost() * 2);
        } else {
            shippingInfo.getShippingCost();
        }
    }

    public double calcTotal() {
        double total = 0;
        this.calcShippingCost();
        for (HashMap.Entry<Product, Integer> product: orderMap.entrySet()) {
            total += product.getKey().getProductPrice() * product.getValue();
        }
        total += shippingInfo.getShippingCost();
        return total;
    }

    public void placeOrder(){
        this.orderConfirmation = true;
    }

    @Override
    public String display() {
        String output = "";
        return output;
    }
}
