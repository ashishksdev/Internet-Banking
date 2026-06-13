package com.across.internetbanking.auth.controller;

import com.across.internetbanking.account.model.Account;
import com.across.internetbanking.auth.exception.UIDAlreadyExistsException;
import com.across.internetbanking.auth.service.SignupService;
import com.across.internetbanking.auth.service.security.PasswordHash;
import com.across.internetbanking.auth.validator.SignupValidation;
import com.across.internetbanking.customer.controller.CustomerForm;
import com.across.internetbanking.customer.dto.CustomerPersonalInfoDTO;
import com.across.internetbanking.customer.factory.CustomerFactory;
import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.factory.UserFactory;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;
import com.across.internetbanking.user.service.UserID;
import com.across.internetbanking.user.validator.IsCompatiblePassword;

public class Signup {

    private final CustomerRepository CUSTOMER_DATA;
    private final UserRepository USER_DATA;
    private final PasswordHash passwordHash;

    public Signup(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA, PasswordHash passwordHash){
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
        this.passwordHash = passwordHash;
    }

    public User onboardClient(){
        Customer customer = customerCreation(); // Create customer
        User user = userCreation(customer); // Create User
        // Account bankAccount = orchestrateAccountCreation(); // Create Account

        SignupService signupService = new SignupService(CUSTOMER_DATA, USER_DATA);

        // Link Bank account---User---Customer, in SignupService

        // After successfull linkage, add to database.
        signupService.addClient(customer,user);
       
        return user;
    }

    private Customer customerCreation(){
        CustomerForm customerForm = new CustomerForm();

        // Get Unique ID input and validate it in databse.
        String uniqueIDInput = customerForm.uniqueID();
        SignupValidation signupValidation = new SignupValidation(CUSTOMER_DATA);
        if(signupValidation.validateUserId(uniqueIDInput)){
            throw new UIDAlreadyExistsException("User already exist.");
        }

        // When Unique ID is validated and found new, collect personal info of customer.
        CustomerPersonalInfoDTO personalInfo = customerForm.personalInfo(uniqueIDInput);
    
        // Create a new customer as per his/her personal details.
        CustomerFactory factory = new CustomerFactory();
        Customer customer = factory.create(personalInfo); // New Customer.

        return customer;
    }

    private User userCreation(Customer customer){
        UserID userID = new UserID(USER_DATA);
        String tempPassword;

        String newUserID = userID.generateUnique(customer.name());
        displayAssignedUserID(newUserID);

        PasswordForm passwordForm = new PasswordForm();
        IsCompatiblePassword validator = new IsCompatiblePassword();

        while (true) { 
            tempPassword  = passwordForm.promptForPassword(); // Password input

            if(validator.validate(tempPassword)){
                break; // Password validated true.
            }
            System.err.println("Password must be at least 4 characters and contain an uppercase, lowercase, digit, and symbol. Retry!"); // Password denied in validation message.
        }
        final String validPassword = tempPassword;
        String salt = passwordHash.generateSalt();
        String hashedPassword = passwordHash.hashPassword(validPassword, salt);

        // Create a new User as per User ID and Password.
        UserFactory factory = new UserFactory();
        User user = factory.create(newUserID,hashedPassword,salt, passwordHash);

        return user;
    }

    public void displayAssignedUserID(String userID){
        System.out.printf("Your User ID: %s%n", userID);
    }

    private Account orchestrateAccountCreation(){
        return new Account();
    }
}