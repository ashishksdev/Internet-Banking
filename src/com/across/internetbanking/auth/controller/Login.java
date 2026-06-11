package com.across.internetbanking.auth.controller;

import com.across.internetbanking.auth.dto.LoginDTO;
import com.across.internetbanking.auth.exception.LoginFailedException;
import com.across.internetbanking.auth.validator.LoginValidation;
import com.across.internetbanking.core.util.AppConstants;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;

public class Login {
    UserRepository USER_DATA;
    LoginController loginController;
    LoginValidation loginValidation;

    public Login(UserRepository USER_DATA){
        this.USER_DATA = USER_DATA;
        this.loginController = new LoginController();
        this.loginValidation = new LoginValidation(USER_DATA);
    }
    public Login(UserRepository USER_DATA, LoginController loginController, LoginValidation loginValidation){
        this.USER_DATA = USER_DATA;
        this.loginController = loginController;
        this.loginValidation = loginValidation;
    }

    User loginUser(){

        LoginDTO loginDTO;
        int attempt = 1;
        boolean userExists;
        boolean validCredentials;

        while (true) {

            if(attempt > AppConstants.MAX_LOGIN_FAILURE){
                throw new LoginFailedException("Login failed! Maximum limit reached.");
            }
            loginDTO = loginController.promptForLoginInfo(); // Input login credentials

            userExists = loginValidation.validateUser(loginDTO);  // Validate User ID
            
            if(userExists){
                validCredentials = loginValidation.validateCredentials(loginDTO); // validate login credentials
            } else {
                loginController.displayInvalidLoginCredentialsMessage();
                attempt++;
                continue;
            }

            if(validCredentials){
                return USER_DATA.getUser(loginDTO.userIDInput()); // Return valid User
            }

            loginController.displayInvalidLoginCredentialsMessage();
            attempt++;
        }
    }
    
}