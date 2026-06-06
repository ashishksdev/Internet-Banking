package com.across.internetbanking.core;

import com.across.internetbanking.auth.controller.AuthController;
import com.across.internetbanking.core.util.*;
import com.across.internetbanking.customer.repository.CustomerData;
import com.across.internetbanking.user.repository.UserData;

public class MainController {
    public static final CustomerData CUSTOMER_DATA = new CustomerData();
    public static final UserData USER_DATA = new UserData();
    private static final AuthController authController = new AuthController(CUSTOMER_DATA, USER_DATA);
    
    private static int attemptCount = 1;

    public MainController(){}

    public void start(){
        
        while(attemptCount <= AppConstants.MAX_AUTH_ATTEMPT){
            boolean isSuccess = authController.start();
            if(isSuccess){ break; }
            
            atteptLeftMessage();
            attemptCount++;
        }

    }

    private static void atteptLeftMessage(){
        System.out.printf("Attempt left: %d\n\n", (AppConstants.MAX_AUTH_ATTEMPT-attemptCount)); // Attempt left message.
    }

}