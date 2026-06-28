package com.across.internetbanking.auth.service;

import com.across.internetbanking.account.model.Account;
import com.across.internetbanking.account.repository.AccountRepository;
import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;

public class SignupService {

    private CustomerRepository CUSTOMER_DATA;
    private UserRepository USER_DATA;
    private AccountRepository ACCOUNT_DATA;

    public SignupService(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA, AccountRepository ACCOUNT_DATA) {
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
        this.ACCOUNT_DATA = ACCOUNT_DATA;
    }

    
    public void link(Customer customer, User user, Account account){
        user.linkAC(account.accountNumber()); // Link User to Bank Account number.
        user.linkCustomer(customer.customerID()); // Link User to Customer.
        account.linkCustomer(customer.customerID()); // Link Account to customer
        customer.linkAccount(account.accountNumber()); // link customer to Account.
        customer.linkUser(user.userID); // Link Customer to user.
    } 

    public void addClient(Customer customer, User user, Account account){
        CUSTOMER_DATA.update(customer);
        USER_DATA.update(user);
        ACCOUNT_DATA.update(account);

    }
}