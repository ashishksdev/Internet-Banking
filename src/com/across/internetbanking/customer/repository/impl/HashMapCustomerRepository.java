package com.across.internetbanking.customer.repository.impl;

import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.customer.repository.CustomerRepository;
import java.util.HashMap;

public class HashMapCustomerRepository implements CustomerRepository {
    private final HashMap<String, Customer> customerDataTable = new HashMap<>();

    @Override
    public void update(Customer customer){
        customerDataTable.put(customer.uniqueID(), customer);
    }

    @Override
    public boolean exists(String uniqueID){
        return customerDataTable.containsKey(uniqueID);
    }
}