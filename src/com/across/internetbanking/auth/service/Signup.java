package com.across.internetbanking.auth.service;

import com.across.internetbanking.auth.exception.UIDAlreadyExistsException;
import com.across.internetbanking.auth.validator.SignupValidation;
import com.across.internetbanking.core.util.Input;
import com.across.internetbanking.customer.controller.*;
import com.across.internetbanking.customer.model.*;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.controller.UserFactory;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;

public class Signup {

    public CustomerRepository CUSTOMER_DATA;
    public UserRepository USER_DATA;

    public Signup(){}

    public Signup(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA){
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
    }

    public boolean registerCustomer(){

        // Customer
        System.out.print("Enter Unique ID: ");
        String uniqueIDInput = Input.sc.next();

        // validate user id uniquness.
        SignupValidation signupValidation = new SignupValidation(CUSTOMER_DATA);
        if(signupValidation.validateUserId(uniqueIDInput)){
            throw new UIDAlreadyExistsException("User already exist.");
        } 
        
        // Call Customer Controller to create customer and then update in database.
        CustomerFactory customerFactory = new CustomerFactory();
        Customer customer = customerFactory.create(uniqueIDInput); // Call to create customer
        CUSTOMER_DATA.update(customer); // Add customer to customer database.
        
        //User
        // Call User Controller to generate new customer's User.
        UserFactory userFactory = new UserFactory();
        User user = userFactory.create(customer);
        // User data update
        USER_DATA.update(user.userID, user.password);

        return true;
    }

    

}