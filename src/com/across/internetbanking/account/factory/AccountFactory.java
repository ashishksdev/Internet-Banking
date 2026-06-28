package com.across.internetbanking.account.factory;

import com.across.internetbanking.account.model.*;

public class AccountFactory {
    private final AccountType accountType;
    private Account account;

    public AccountFactory(AccountType accountType){
        this.accountType = accountType;
    }

    public Account create(String accountNumber){

        
        switch(accountType){

            case SAVING -> {
                account = new SavingAccount(accountNumber);
            }
            
            case CURRENT -> {
                account = new CurrentAccount(accountNumber);
            }
            default -> throw new IllegalArgumentException();
        }

        return account;
    }
}
