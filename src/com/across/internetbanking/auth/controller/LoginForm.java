package com.across.internetbanking.auth.controller;

import com.across.internetbanking.auth.dto.LoginDTO;
import com.across.internetbanking.core.util.Input;

public class LoginForm {
    public LoginDTO loginCredentials(){
        // Input login credentials (userID and Password) for login.
        System.out.print("User ID: ");
        String inputUserID = Input.sc.next().trim().toLowerCase(); // User ID input in String format.
        System.out.print("Password: ");
        String inputPassword = Input.sc.next().trim(); // Password input.

        return new LoginDTO(inputUserID, inputPassword);
    }
}