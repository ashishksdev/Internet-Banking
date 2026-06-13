package com.across.internetbanking.auth.controller;

import com.across.internetbanking.auth.dto.LoginDTO;
import com.across.internetbanking.auth.validator.LoginValidation;
import com.across.internetbanking.core.exception.SessionLimitReachedException;
import com.across.internetbanking.core.util.AppConstants;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;

public class Login {
    private final UserRepository USER_DATA;
    private final LoginForm loginForm;
    private final LoginValidation loginValidation;

    public Login(UserRepository USER_DATA){
        this.USER_DATA = USER_DATA;
        this.loginForm = new LoginForm();
        this.loginValidation = new LoginValidation(USER_DATA);
    }
    public Login(UserRepository USER_DATA, LoginForm loginController, LoginValidation loginValidation){
        this.USER_DATA = USER_DATA;
        this.loginForm = loginController;
        this.loginValidation = loginValidation;
    }

    User loginUser(){

        LoginDTO loginDTO;
        int attempt = 1;
        boolean userExists;
        boolean validCredentials;

        while (true) {
            
            // Implement session limit
            if(attempt > AppConstants.MAX_LOGIN_FAILURE){
                throw new SessionLimitReachedException("Login failed! Maximum limit reached.");
            }

            loginDTO = loginForm.loginCredentials(); // Input login credentials

            userExists = loginValidation.validateUser(loginDTO);  // Validate User ID
            
            if(userExists){
                validCredentials = loginValidation.validateCredentials(loginDTO); // validate login credentials
            } else {
                displayInvalidLoginCredentialsMessage();
                attempt++;
                continue;
            }

            if(validCredentials){
                return USER_DATA.getUser(loginDTO.userIDInput()); // Return valid User
            }

            displayInvalidLoginCredentialsMessage();
            attempt++;
            
        }

    }

    public void displayInvalidLoginCredentialsMessage(){
        System.out.println("Invalid User ID or password. Try again!");
    }
    
}