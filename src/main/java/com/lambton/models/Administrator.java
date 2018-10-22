package com.lambton.models;

import com.lambton.utils.IDisplay;

public class Administrator extends User implements IDisplay {
    private String adminName;
    private String email;

    public Administrator(String password, String adminName, String email) {
        super(password);
        this.adminName = adminName;
        this.email = email;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Product addProductToCatalog(String productName, double productPrice) {
        return new Product(productName, productPrice);
    }

    @Override
    public String display() {
        String output = "\nAdmin ID: " + super.getUserId()
                + "\nAdmin Email: " + email
                + "\nAdmin Name: " + adminName;
        return output;
    }
}
