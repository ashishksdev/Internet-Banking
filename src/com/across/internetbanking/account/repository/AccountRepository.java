package com.across.internetbanking.account.repository;

import com.across.internetbanking.account.model.Account;

public interface AccountRepository {
    public void update(Account account);
    public boolean exists(String accountNumber);
    public Account getAccount(String accountNumber);
}
