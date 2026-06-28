package com.across.internetbanking.account.model;

import com.across.internetbanking.transcation.service.Withdrawl;

public class CurrentAccount extends Account implements Withdrawl {
    double overDraft;

    public CurrentAccount(String accountNumber){
        super(accountNumber);
    }

    @Override
    public void withdraw(){

    }
}