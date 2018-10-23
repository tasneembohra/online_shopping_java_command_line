package com.lambton.models;

import com.lambton.utils.IDisplay;

public class Administrator extends User implements IDisplay {
    private String adminName;
    private String email;

    public Administrator(int userdId, String password, String adminName, String email) {
        super(userdId, password);
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

    public Product addProductToCatalog(int id, String productName, double productPrice) {
        return new Product(id, productName, productPrice);
    }

    @Override
    public String display() {
        return "\nAdmin ID: " + super.getUserId()
                + "\nAdmin Email: " + email
                + "\nAdmin Name: " + adminName;
    }
}
