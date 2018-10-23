package com.lambton.models;

import com.google.gson.annotations.SerializedName;
import com.lambton.utils.IDisplay;
import com.lambton.utils.TextFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order implements IDisplay {

    @SerializedName("id")
    private int orderId;
    private long dateCreated;
    private long dateShipped;
    @SerializedName("status")
    private String status;
    @SerializedName("products")
    private ArrayList<OrderedProduct> products;
    @SerializedName("customer")
    private Customer customer;
    @SerializedName("confirmedOrder")
    private boolean orderConfirmation = false; //confirmation


    public Order(ShoppingCart shoppingCart) {
        products = shoppingCart.getProducts();
        customer = shoppingCart.getCustomer();
    }

    public boolean isOrderConfirmation() {
        return orderConfirmation;
    }

    public int getOrderId() {
        return orderId;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public long getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(long dateShipped) {
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
        return customer.getShippingInfo();
    }

    public void updateShippingInfo(ShippingInfo shippingInfo) {
        customer.setShippingInfo(shippingInfo);
    }

    public void setShippingType(String type) {
        customer.getShippingInfo().setShippingType(type);
        switch (type) {
            case "Post": customer.getShippingInfo().setShippingCost(10.0);
                        break;
            case "Courier": customer.getShippingInfo().setShippingCost(20.0);
                        break;
        }
    }

    public void calcShippingCost() {
        int productCount = 0;
        for (OrderedProduct orderedProduct : products) {
            productCount += orderedProduct.getQuantity();
        }
        if (productCount > 10) {
            customer.getShippingInfo().setShippingCost(customer.getShippingInfo().getShippingCost() * 2);
        } else if (productCount > 5) {
            customer.getShippingInfo().setShippingCost(customer.getShippingInfo().getShippingCost() * 1.5);
        }
    }

    public double calcTotal() {
        double total = 0;
        this.calcShippingCost();
        for (OrderedProduct orderedProduct : products) {
            total += orderedProduct.calculatePrice();
        }
        total += customer.getShippingInfo().getShippingCost();
        return total;
    }

    public void placeOrder(){
        this.orderConfirmation = true;
    }

    public void cancelOreder() {
        this.orderConfirmation = false;
    }

    public String viewOrderList() {
        StringBuilder builder = new StringBuilder();
        for (OrderedProduct orderedProduct : products) {
            builder.append("\n\t\t\tProduct name: ").append(orderedProduct.getProduct().getProductName())
                    .append("\n\t\t\tPrice for unit: ").append(TextFormatter.currency(orderedProduct.getProduct().getProductPrice()))
                    .append("\n\t\t\tQuantity: ").append(orderedProduct.getQuantity())
                    .append("\n\t\t\tProduct Price: ").append(TextFormatter.currency(orderedProduct.calculatePrice()));
        }
        return builder.toString();
    }

    @Override
    public String display() {
        SimpleDateFormat format = new SimpleDateFormat("MMM dd, YYYY");
        return customer.display()
                + "\n\rOrder ID: " + orderId
                + "\n\tDate Created: " + format.format(new Date(dateCreated))
                + "\n\tStatus: " + status
                + "\n\tDate Shipped: " + format.format(new Date(dateShipped))
                + "\n\tOrder List: \t" + this.viewOrderList()
                + "\n\rTotal: " + TextFormatter.currency(this.calcTotal()) + " (Shipping Cost: " + TextFormatter.currency(customer.getShippingInfo().getShippingCost()) + " )";
    }
}
