package com.lambton.models;

import com.google.gson.annotations.SerializedName;

public class Customer extends User {
    @SerializedName("name")
    private String customerName;
    @SerializedName("email")
    private String email;
    @SerializedName("creditcard")
    private String creditCardInfo;
    @SerializedName("shippingInfo")
    private ShippingInfo shippingInfo; //last or default shipping info

    public Customer(int userId, String password, String customerName, String email, String creditCardInfo, ShippingInfo shippingInfo) {
        super(userId, password);
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
        return "\n\rCustomer ID: " + super.getUserId()
                + "\nCustomer Name: " + customerName
                + "\nCustomer Email: " + email
                + "\nCustomer CreditCard: " + creditCardInfo
                + "\nShipping Information: \t" + shippingInfo.display();
    }
}
