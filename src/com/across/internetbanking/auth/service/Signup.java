package com.across.internetbanking.auth.service;

import com.across.internetbanking.customer.controller.CustomerController;
import com.across.internetbanking.customer.dto.CustomerPersonalInfoDTO;
import com.across.internetbanking.customer.factory.CustomerFactory;
import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.controller.UserController;
import com.across.internetbanking.user.factory.UserFactory;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;
import com.across.internetbanking.user.service.UserID;

public class Signup {

    public CustomerRepository CUSTOMER_DATA;
    public UserRepository USER_DATA;

    public Signup(){}

    public Signup(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA){
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
    }

    public boolean onboardClient(){
        Customer customer = orchestrateCustomerCreation(); // Create customer
        User user = orchestrateUserCreation(customer); // Create User

        // Bank Account will be created
        // All three, Customer, User and Bank Account will be linked together.
        // After Suuccessfull creation of Customer, User, BAnk account and linkage between them established, everything will be passed to concerned data repository.
        return true;
    }

    private Customer orchestrateCustomerCreation(){
        CustomerController customerController = new CustomerController(CUSTOMER_DATA);

        String uniqueID = customerController.promptForValidUniqueID(); // Validate unique id input, if it is not already in database.
        CustomerPersonalInfoDTO personalInfo = customerController.promptForValidPersonalInfo(uniqueID);

        // Create a new customer as per his/her personal details.
        CustomerFactory factory = new CustomerFactory();
        Customer customer = factory.create(personalInfo); // New Customer.

        return customer;
    }

    private User orchestrateUserCreation(Customer customer){
        UserController userController = new UserController();
        UserID userID = new UserID();

        String newUserID = userID.generate(customer.firstName()); // Genrate User ID
        userController.displayAssignedUserID(newUserID); // Diplay assigned User ID
        String validPassword = userController.promptForValidPassword(); // Validate Password

        // Create a new User as per User ID and Password.
        UserFactory factory = new UserFactory();
        User user = factory.create(newUserID,validPassword);

        return user;
    }
}