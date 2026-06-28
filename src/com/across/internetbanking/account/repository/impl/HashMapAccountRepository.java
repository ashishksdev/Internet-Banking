package com.across.internetbanking.account.repository.impl;

import com.across.internetbanking.account.model.Account;
import com.across.internetbanking.account.repository.AccountRepository;
import java.util.HashMap;
import java.util.Map;

public class HashMapAccountRepository implements AccountRepository {
    private final Map<String, Account> accountDataTale = new HashMap<>();

    @Override
    public void update(Account account){
        accountDataTale.put(account.accountNumber(), account);
    }

    @Override
    public boolean exists (String accountNumberInput){
        return accountDataTale.containsKey(accountNumberInput);
    }

    @Override
    public Account getAccount(String accountNumber){
        return accountDataTale.get(accountNumber);
    }
}