package com.lambton.models;

import com.google.gson.annotations.SerializedName;
import com.lambton.utils.IDisplay;

public abstract class User implements IDisplay {
    @SerializedName("id")
    protected int userId = 0;
    private String password;
    private String loginStatus;

    public User() { }

    public User(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int useId) {
        this.userId = useId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public boolean verifyLogin(int userId, String password) {
        if (this.userId == userId && this.password.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    
}
