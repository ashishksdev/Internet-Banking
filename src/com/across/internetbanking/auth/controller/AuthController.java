package com.across.internetbanking.auth.controller;

import com.across.internetbanking.auth.exception.LoginFailedException;
import com.across.internetbanking.auth.exception.UIDAlreadyExistsException;
import com.across.internetbanking.auth.service.AuthAction;
import com.across.internetbanking.core.exception.SessionLimitReachedException;
import com.across.internetbanking.core.util.*;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.user.repository.UserRepository;

public class AuthController {

    private final CustomerRepository CUSTOMER_DATA;
    private final UserRepository USER_DATA;
    private final Signup SIGNUP; 
    private final Login LOGIN;
    private int failedCount = 1;

    public AuthController(CustomerRepository CUSTOMER_DATA, UserRepository USER_DATA){
        this.CUSTOMER_DATA = CUSTOMER_DATA;
        this.USER_DATA = USER_DATA;
        SIGNUP = new Signup(CUSTOMER_DATA, USER_DATA);
        LOGIN = new Login(USER_DATA);
    }

    public void start(){
        verifySessionLimit(); // Session limit verification

        try {
            // User input for signup(login/open) action.
            System.out.print(AppConstants.AUTH_TYPE_OPTION);
            String actionInput = Input.sc.next().trim().toUpperCase(); // User Signup request string.
            AuthAction authActionRequest = AuthAction.valueOf(actionInput); // Convert UserSignupRequest to Enum from string, for request verification.
            
            // Execute request
            execute(authActionRequest);
            
        } catch (IllegalArgumentException invalidInpException) {
            System.err.println("Invalid request. Please enter LOGIN or OPEN.");
        } catch (UIDAlreadyExistsException uidaee){
            System.err.println(uidaee.getMessage());
            attemptLeftMessage(failedCount);
            failedCount++;
        } catch (LoginFailedException lfe){
            System.out.println(lfe.getMessage());
            failedCount++;
        }

    }

    private void execute(AuthAction request){

        // Auth action request execute.
        switch(request){
            case OPEN -> {
                SIGNUP.onboardClient();
                System.out.println("\n>>> Signup successful! Please login to your account.\n");
            }
            case LOGIN -> {
                LOGIN.loginUser();
                // Give access to account
                System.out.println("Hello [Name]!");
            }
            default -> throw new IllegalArgumentException();
        }

    }

    private void verifySessionLimit(){
        if (failedCount > AppConstants.MAX_CONSECUTIVE_FAILURE){
            throw new SessionLimitReachedException();
        }
    }

    private void attemptLeftMessage(int failedCount){
        System.out.printf("Attempt left: %d\n\n", (AppConstants.MAX_CONSECUTIVE_FAILURE-failedCount)); // Attempt left message.
    }
}