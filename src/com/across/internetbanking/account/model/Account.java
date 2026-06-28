package com.across.internetbanking.account.model;

import java.math.BigDecimal;

public abstract class Account {
    private String customerID;
    private final String accountNumber;
    private AccountStatus status;
    private BigDecimal balance;

    public Account(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String accountNumber(){
        return accountNumber;
    }

    public void linkCustomer(String customerID){
        this.customerID = customerID;
    }

    public void updateAcStatus(AccountStatus status){
        this.status = status;
    }

    public AccountStatus curreAccountStatus(){
        return status;
    }
    
    public String customerID(){
        return customerID;
    }
}