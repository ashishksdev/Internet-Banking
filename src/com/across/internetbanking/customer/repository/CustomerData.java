package com.across.internetbanking.customer.repository;

import java.util.HashMap;
import com.across.internetbanking.customer.model.Customer;

public class CustomerData {
    HashMap<String, Customer> customerDataTable = new HashMap<>();
    public void update(Customer customer){
        customerDataTable.put(customer.uniqueID(), customer);
    }
}