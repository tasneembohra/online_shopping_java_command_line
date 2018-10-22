package com.lambton.models;

public class Customer extends User {
    private String customerName;
    private String email;
    private String creditCardInfo;
    private ShippingInfo shippingInfo; //last or default shipping info

    public Customer(String password, String customerName, String email, String creditCardInfo, ShippingInfo shippingInfo) {
        super(password);
        this.customerName = customerName;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.shippingInfo = shippingInfo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }


    public void updateShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    @Override
    public String display() {
        String output = "";
        return output;
    }
}
