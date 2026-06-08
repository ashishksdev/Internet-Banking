package com.across.internetbanking.customer.controller;

import com.across.internetbanking.auth.exception.UIDAlreadyExistsException;
import com.across.internetbanking.auth.validator.SignupValidation;
import com.across.internetbanking.core.util.Input;
import com.across.internetbanking.customer.dto.CustomerPersonalInfoDTO;
import com.across.internetbanking.customer.repository.CustomerRepository;

public class CustomerController {
    CustomerRepository CUSTOMER_DATA;

    public CustomerController(CustomerRepository CUSTOMER_DATA){
        this.CUSTOMER_DATA = CUSTOMER_DATA;
    }

    public String promptForValidUniqueID(){
        // Input Unique ID.
        System.out.print("Enter Unique ID: ");
        String uniqueIDInput = Input.sc.next();

        // validate user id uniquness.
        SignupValidation signupValidation = new SignupValidation(CUSTOMER_DATA);
        if(signupValidation.validateUserId(uniqueIDInput)){
            throw new UIDAlreadyExistsException("User already exist.");
        }
        return uniqueIDInput;
    }

    public CustomerPersonalInfoDTO promptForValidPersonalInfo(String uniqueID){
        
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

        CustomerPersonalInfoDTO personalInfo = new CustomerPersonalInfoDTO(uniqueID, firstName, lastName, gender, age, mobileNo);
        
        return personalInfo;
    }
}
