package com.across.internetbanking.customer.controller;

import com.across.internetbanking.core.util.Input;
import com.across.internetbanking.customer.model.*;

public class CustomerFactory {
    Customer customer;

    public CustomerFactory(){}

    public Customer create(String uniqueID){
        // Collect customer personal details.
        System.out.print("Full name: ");
        String firstName = Input.sc.next();
        String lastName = Input.sc.next();
        Input.sc.nextLine();

        System.out.print("Gender: ");
        char gender = Input.sc.next().charAt(0);

        System.out.print("Age: ");
        int age = Input.sc.nextInt();

        System.out.print("Mobile: ");
        long mobileNo = Input.sc.nextLong();

        // Create a customer as per his/her personal details.
        customer = new Customer(uniqueID, firstName,lastName,gender,age,mobileNo); // New Customer.
        
        return customer;
    }
}
