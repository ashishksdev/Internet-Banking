package com.across.internetbanking.dashboard.controller;

import com.across.internetbanking.account.model.Account;
import com.across.internetbanking.account.repository.AccountRepository;
import com.across.internetbanking.account.validator.AccountStatusValidator;
import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.dashboard.exception.AccountNotActiveException;
import com.across.internetbanking.user.model.User;

public class Dashboard {

    private final User user;
    private Account account;
    private Customer customer;
    private final AccountRepository ACCOUNT_DATA;
    private final CustomerRepository CUSTOMER_DATA;

    public Dashboard(User user, AccountRepository ACCOUNT_DATA, CustomerRepository CUSTOMER_DATA){
        this.user = user;
        this.ACCOUNT_DATA = ACCOUNT_DATA;
        this.CUSTOMER_DATA = CUSTOMER_DATA;
    }

    public void start(){
        String accountNumber = user.accountNumber();
        account = ACCOUNT_DATA.getAccount(accountNumber);

        AccountStatusValidator validator = new AccountStatusValidator(account);
        if(!validator.validateActive()){
            throw new AccountNotActiveException("Account is not active.");
        }

        customer = CUSTOMER_DATA.getCustomer(account.customerID());
        // Welcome message
        printWelcomeMessage(customer.name());

    }

    public void printWelcomeMessage(String name){
        System.out.printf("Hello %s%n!", name);
    }
   
}