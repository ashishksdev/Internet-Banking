package com.across.internetbanking.auth.validator;

import com.across.internetbanking.customer.repository.CustomerRepository;

public class SignupValidation {
    CustomerRepository CUSTOMER_DATA;

    public SignupValidation(CustomerRepository CUSTOMER_DATA) {
        
        this.CUSTOMER_DATA = CUSTOMER_DATA;
    }

    public boolean validateUserId(String uniqueIDInput){
        return CUSTOMER_DATA.exists(uniqueIDInput); 
    }
}