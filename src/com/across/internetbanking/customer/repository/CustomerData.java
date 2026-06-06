package com.across.internetbanking.customer.repository;

import com.across.internetbanking.customer.model.Customer;
import java.util.HashMap;

public class CustomerData {
    HashMap<String, Customer> customerDataTable = new HashMap<>();

    public void update(Customer customer){
        customerDataTable.put(customer.uniqueID(), customer);
    }

    public boolean exists(String uniqueID){
        return customerDataTable.containsKey(uniqueID);
    }
}