package com.across.internetbanking.account.model;

public abstract class Account {

    /* Identity */
    protected AccountId userID;
    protected String accountNumber;
    protected int customerID;

    /* State */
    //protected AccountStatus status;
    protected AccountType type;
    //protected Money balance;

    protected Account(String accountNumber, AccountType type, int customerID){
        this.accountNumber = accountNumber;
        this.type = type;
        this.customerID = customerID;
    }

    // Account behaviour

    protected void deposit(){
         
    }   
     
    protected void withdraw(){
         
    }

    protected double balance(){
        return 0;

    }
    
}  

class AccountId {
    String firstName;
    long serial;

    AccountId(String firstName, long serial) {
        this.firstName = firstName;
        this.serial = serial;
    }
}
