package com.lambton.models;

import com.google.gson.annotations.SerializedName;

public class OrderedProducts {
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("product")
    private Product product;
}
