package com.across.internetbanking.user.controller;

import com.across.internetbanking.core.util.Input;
import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.user.exception.PasswordNotCompatibleException;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.service.GenerateUser;

public class UserFactory {
    String readyUserID;
    String readyPassword;
    
    public UserFactory(){}
    
    public User create(Customer customer) {

        GenerateUser generateUser = new GenerateUser(customer);

        createUserID(generateUser); // Finalise User ID, yet to be allocated.

        // Create password. Yet to be allocated.
        boolean passwordCreatedSuccessfully = false;
        while(!passwordCreatedSuccessfully){
            passwordCreatedSuccessfully = createPassword(generateUser);
        }

        // Create actual User with user ID and Password.
        User user = new User(readyUserID, readyPassword);

        return user; // return user.
    }

    public void createUserID(GenerateUser generateUser){
        // Genearte a new UserId.
        String userID = generateUser.userID(); // returns a new system generated userId.
        this.readyUserID = userID;
        System.out.printf("Your User ID: %s%n", userID); // Output Customer's User ID.
    }

    public boolean createPassword(GenerateUser generateUser){

        try {
            // Ask to create password for User Id.
            System.out.print("Create password: ");
            final String tempPassword = Input.sc.next();
            boolean compatiblePassword = generateUser.compatiblePassword(tempPassword);

            System.out.print("Confirm password: ");
            final String confirmPassword = Input.sc.next();
            boolean eligiblePassword = generateUser.eligiblePassword(tempPassword, confirmPassword);

            if(eligiblePassword){
                this.readyPassword = confirmPassword;
            } else{
                System.err.println("Password mismatch! Retry!");
                return false;
            }

            return compatiblePassword && eligiblePassword;
        } catch (PasswordNotCompatibleException pncException) {
            System.err.println(pncException.getMessage());
            return false;
        }
        
    }
}
