package com.across.internetbanking.user.model;

import com.across.internetbanking.auth.service.security.PasswordHash;

public class User {
    private String accountNumber;
    private String customerID;
    public final String userID;
    private String password;
    private String salt;
    PasswordHash passwordHash;

    
    public User(String userID, String password, String salt, PasswordHash passwordHash){
        this.userID = userID;
        this.password = password;
        this.salt = salt;
        this.passwordHash = passwordHash;
    }

    public boolean passwordMatch(String passwordInp){
        String hashOfInputPassword = passwordHash.hashPassword(passwordInp, salt);
        return hashOfInputPassword.equals(password);
    }

    public void linkAC(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void linkCustomer(String customerID){
        this.customerID = customerID;
    }

    public String accountNumber(){
        return accountNumber;
    }

}