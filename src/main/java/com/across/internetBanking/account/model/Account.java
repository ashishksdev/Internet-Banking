package main.java.com.across.netbanking.account.model;

import java.math.BigInteger;

public abstract class Account {

    /* Identity */
    protected long accountID;
    protected String accountNumber;
    protected int customerID;

    /* State */
    protected AccountStatus status;
    protected AccountType type;
    protected Money balance;

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
