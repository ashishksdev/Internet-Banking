package com.across.internetbanking.user.model;

public class User {
    public final String userID;
    private String password;

    public User(String userID, String password){
        this.userID = userID;
        this.password = password;
    }

    public boolean passwordMatch(String passwordInp){
        return passwordInp.equals(password);
    }

}
