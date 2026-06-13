package com.across.internetbanking.auth.service;

import com.across.internetbanking.account.model.Account;
import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;

public class SignupService {

    private CustomerRepository CUSTOMER_DATA;
    private UserRepository USER_DATA;

    public SignupService(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA) {
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
    }

    
    public String link(Customer customer, User user, Account bankAccount){
        String customerID = "";
        return customerID;
    } 

    public void addClient(Customer customer, User user){
        CUSTOMER_DATA.update(customer);
        USER_DATA.update(user);
    }
}