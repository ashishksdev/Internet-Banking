package com.across.internetbanking.account.controller;

import com.across.internetbanking.account.model.AccountType;
import com.across.internetbanking.core.util.Input;

public class AccountForm {
    
    public AccountType promptForAccountDetail(){
        System.out.print("Saving | Current\n>> ");
        AccountType accountTypeInput = AccountType.valueOf(Input.sc.next().toUpperCase().trim());
        Input.sc.nextLine();

        return accountTypeInput;
    }
}