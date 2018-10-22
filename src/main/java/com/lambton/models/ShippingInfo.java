package com.lambton.models;

import com.lambton.utils.IDisplay;

public class ShippingInfo implements IDisplay {
    private int shippingId = 0;
    private String shippingAddress;
    private String shippingType;
    private double shippingCost;
    private String shippingRegionId;

    public ShippingInfo(String shippingAddress, String shippingRegionId) {
        shippingId++;
        this.shippingAddress = shippingAddress;
        this.shippingRegionId = shippingRegionId;
    }

    public int getShippingId() {
        return shippingId;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
        switch (shippingType) {
            case "Post": this.shippingCost = 10.0;
                break;
            case "Courier": this.shippingCost = 20.0;
                break;
        }
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getShippingRegionId() {
        return shippingRegionId;
    }

    public void updateShippingRegionId(String shippingRegionId) {
        this.shippingRegionId = shippingRegionId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void updateShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String display() {
        return "\n\tShipping ID: " + shippingId
                + "\n\tShipping Address: " + shippingAddress
                + "\n\tShipping Region: " + shippingRegionId
                + "\n\tShipping Type: " + shippingType;
    }
}
