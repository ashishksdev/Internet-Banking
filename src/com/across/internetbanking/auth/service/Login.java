package com.across.internetbanking.auth.service;

import com.across.internetbanking.auth.validator.LoginValidaton;
import com.across.internetbanking.core.util.Input;

public class Login {
 
    boolean loginUser(){
        // Input login credentials (userID and Password) for login.
        
        System.out.print("User ID: ");
        String inputUserID = Input.sc.next().trim().toLowerCase(); // UserID input in String format.
        System.out.print("Password: ");
        String inputPassword = Input.sc.next(); // userID's password input.

        try {
            new LoginValidaton().validate(inputUserID, inputPassword);
        } catch (IllegalAccessError e) {
            System.err.println(">> Invalid credentials!\n");
        }

        return true;
    }
}