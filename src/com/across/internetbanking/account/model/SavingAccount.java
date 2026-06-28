package com.across.internetbanking.account.model;

import com.across.internetbanking.transcation.service.Withdrawl;

public class SavingAccount extends Account implements Withdrawl {

    public SavingAccount(String accountNumber){
        super(accountNumber);
    }
    
    @Override
    public void withdraw(){

    }
}