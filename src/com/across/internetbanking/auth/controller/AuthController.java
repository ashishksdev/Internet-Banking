package com.across.internetbanking.auth.controller;

import com.across.internetbanking.auth.exception.UIDAlreadyExistsException;
import com.across.internetbanking.auth.service.AuthAction;
import com.across.internetbanking.auth.service.Login;
import com.across.internetbanking.auth.service.Signup;
import com.across.internetbanking.core.util.*;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.repository.UserRepository;

public class AuthController {

    public CustomerRepository CUSTOMER_DATA;
    public UserRepository USER_DATA;
    public final Signup SIGNUP; 
    public final Login LOGIN;


    public AuthController(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA){
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
        SIGNUP = new Signup(CUSTOMER_DATA, USER_DATA);
        LOGIN = new Login();
    }

    public boolean start(){
        boolean authSuccess = false;

        try {
            // User input for signup(login/open) action.
            System.out.print(AppConstants.AUTH_TYPE_OPTION);
            String actionInput = Input.sc.next().trim().toUpperCase(); // User Signup request string.
            AuthAction request = AuthAction.valueOf(actionInput); // Convert UserSignupRequest to Enum from string, for request verification.
            
            // Execute request
            authSuccess = request.execute(SIGNUP,LOGIN);
            
        } catch (IllegalArgumentException invalidInpException) {
            System.err.println("Invalid request. Please enter LOGIN or OPEN.");
        } catch (UIDAlreadyExistsException uidaee){
            System.err.println(uidaee.getMessage());
        }

        return authSuccess;
    }
}
