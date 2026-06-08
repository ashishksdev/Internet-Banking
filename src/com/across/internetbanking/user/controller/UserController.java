package com.across.internetbanking.user.controller;

import com.across.internetbanking.core.util.Input;
import com.across.internetbanking.core.util.Serial;
import com.across.internetbanking.user.validator.IsCompatiblePassword;

public class UserController {

    public String generateUserID(String firstName) {
        Serial serial = new Serial();
        String userID = String.format("%s%d@across", firstName, serial.serialCount());
        return userID;
    }

    public void displayAssignedUserID(String userID){
        System.out.printf("Your User ID: %s%n", userID);
    }
    
    public String promptForValidPassword(){
        IsCompatiblePassword validator = new IsCompatiblePassword();

        while (true) { 
            System.out.print("Create Password: ");
            String tempPassword = Input.sc.next();
           
            if(!validator.validate(tempPassword)){
                System.err.println("Password must be at least 4 chars and contain an uppercase, lowercase, digit, and symbol. Retry!");
                continue;
            }

            System.out.print("Confirm password: ");
            String confirmPassword = Input.sc.next();

            if(!tempPassword.equals(confirmPassword)){
                System.err.println("Password mismatch! Retry!");
                continue;
            }
           return confirmPassword;
        }
    }
}
