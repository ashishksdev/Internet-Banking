package com.across.internetbanking.account.validator;

import com.across.internetbanking.account.model.Account;
import com.across.internetbanking.account.model.AccountStatus;

public class AccountStatusValidator {
    private final Account account;

    public AccountStatusValidator(Account account){
        this.account = account;
    }

    public boolean validateActive(){
        AccountStatus acStatus = account.curreAccountStatus();
        return acStatus == AccountStatus.ACTIVE;
    }
}