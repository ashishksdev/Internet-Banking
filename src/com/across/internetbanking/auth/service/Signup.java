package com.across.internetbanking.auth.service;

import com.across.internetbanking.customer.model.*;

public class Signup {

    public void registerCustomer(AuthenticationService authService){
        // Customer 
        Customer customer =  new Customer();
        customer.collectCustomerInfo();
        
        authService.customerData.update(customer); // Updata Databse of costumer.
        customer.generateUser();

        // User data update
        authService.userData.update(customer.user.userID, customer.user.password);

        // Bank Account
        
    }
}