package com.lambton.models;

import com.lambton.utils.IDisplay;
import com.sun.tools.internal.ws.wsdl.document.Output;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Order implements IDisplay {

    private int orderId = 0;
    private Date dateCreated;
    private Date dateShipped;
    private String status;
    private HashMap<Product, Integer> orderMap;
    private Customer customer;
    private boolean orderConfirmation = false; //confirmation

    public Order(ShoppingCart shoppingCart) {
        orderId++;
        dateCreated = new GregorianCalendar().getTime();
        orderMap = shoppingCart.getCartMap();
        customer = shoppingCart.getCustomer();
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
        for (HashMap.Entry<Product, Integer> product: orderMap.entrySet()) {
            productCount += product.getValue();
        }
        if (productCount > 5) {
            customer.getShippingInfo().setShippingCost(customer.getShippingInfo().getShippingCost() * 1.5);
        } else if (productCount > 10) {
            customer.getShippingInfo().setShippingCost(customer.getShippingInfo().getShippingCost() * 2);
        }
    }

    public double calcTotal() {
        double total = 0;
        this.calcShippingCost();
        for (HashMap.Entry<Product, Integer> product: orderMap.entrySet()) {
            total += product.getKey().getProductPrice() * product.getValue();
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
        String output = "";
        for (HashMap.Entry<Product, Integer> item: orderMap.entrySet()) {
            output += "\n\tProduct name: " + item.getKey().getProductName()
                    + "\n\tPrice for unit: " + item.getKey().getProductPrice()
                    + "\n\tQuantity: " + item.getValue();
        }
        return output;
    }

    @Override
    public String display() {
        String output = customer.display()
                + "\nOrder ID: " + orderId
                + "\nDate Created: " + dateCreated
                + "\nStatus: " + status
                + "\nDate Shipped: " + dateShipped
                + "\nOrder List: \t" + this.viewOrderList()
                + "\nTotal: " + this.calcTotal() + " (Shipping Cost: " + customer.getShippingInfo().getShippingCost() + " )";
        return output;
    }
}
