package com.across.internetbanking.customer.repository;

import com.across.internetbanking.customer.model.Customer;

public interface CustomerRepository {
    void update(Customer customer);
    boolean exists(String uniqueID);
    Customer getCustomer(String customerID);
}