package com.lambton.models;

public class ShippingInfo {
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
}
