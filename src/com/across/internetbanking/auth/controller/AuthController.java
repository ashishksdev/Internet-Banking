package com.across.internetbanking.auth.controller;

import com.across.internetbanking.auth.exception.LoginFailedException;
import com.across.internetbanking.auth.exception.UIDAlreadyExistsException;
import com.across.internetbanking.auth.service.Signup;
import com.across.internetbanking.core.exception.SessionLimitReachedException;
import com.across.internetbanking.core.util.*;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.repository.UserRepository;

public class AuthController {

    public CustomerRepository CUSTOMER_DATA;
    public UserRepository USER_DATA;
    public final Signup SIGNUP; 
    public final Login LOGIN;
    int failedCount = 1;

    public AuthController(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA){
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
        SIGNUP = new Signup(CUSTOMER_DATA, USER_DATA);
        LOGIN = new Login(USER_DATA);
    }

    public void start(){
        verfySessionLimit(); // Session limit verification

        try {
            // User input for signup(login/open) action.
            System.out.print(AppConstants.AUTH_TYPE_OPTION);
            String actionInput = Input.sc.next().trim().toUpperCase(); // User Signup request string.
            AuthAction request = AuthAction.valueOf(actionInput); // Convert UserSignupRequest to Enum from string, for request verification.
            
            // Execute request
            request.execute(SIGNUP,LOGIN);
            authSuccessfullTrigger(request);
            
        } catch (IllegalArgumentException invalidInpException) {
            System.err.println("Invalid request. Please enter LOGIN or OPEN.");
        } catch (UIDAlreadyExistsException uidaee){
            System.err.println(uidaee.getMessage());
            atteptLeftMessage(failedCount);
            failedCount++;
        } catch (LoginFailedException lfe){
            System.out.println(lfe.getMessage());
            failedCount++;
        }

    }

    private void authSuccessfullTrigger(AuthAction request){

        if(request.equals(AuthAction.LOGIN)){
            
            // Give access to account
            System.out.println("Hello [Name]!");
            
        } else if(request.equals(AuthAction.OPEN)){
           System.out.println("\n>>> Signup successful! Please login to you account.\n");
        }

    }

    private void verfySessionLimit(){
        if (failedCount > AppConstants.MAX_CONSECUTIVE_FAILURE){
            throw new SessionLimitReachedException();
        }
    }

    private void atteptLeftMessage(int failedCount){
        System.out.printf("Attempt left: %d\n\n", (AppConstants.MAX_CONSECUTIVE_FAILURE-failedCount)); // Attempt left message.
    }
}