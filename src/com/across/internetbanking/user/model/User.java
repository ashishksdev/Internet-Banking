package com.across.internetbanking.user.model;

public class User {
    public final String userID;
    public String password;

    public User(String userID, String password){
        this.userID = userID;
        this.password = password;
    }

}
