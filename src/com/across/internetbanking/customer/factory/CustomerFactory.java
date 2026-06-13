package com.across.internetbanking.customer.factory;

import com.across.internetbanking.customer.dto.CustomerPersonalInfoDTO;
import com.across.internetbanking.customer.model.Customer;

public class CustomerFactory {
    public Customer create(CustomerPersonalInfoDTO personalInfo){
        Customer newCustomer = new Customer(
            personalInfo.uniqueID(),
            personalInfo.name(),
            personalInfo.gender(),
            personalInfo.age(),
            personalInfo.mobileNo()
        );
        return newCustomer;
    }
}