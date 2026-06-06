package com.across.internetbanking.auth.validator;

import com.across.internetbanking.customer.repository.CustomerData;

public class SignupValidation {
    CustomerData CUSTOMER_DATA;

    public SignupValidation(CustomerData CUSTOMER_DATA) {
        
        this.CUSTOMER_DATA = CUSTOMER_DATA;
    }

    public boolean validateUserId(String uniqueIDInput){
        return CUSTOMER_DATA.exists(uniqueIDInput); 
    }
}