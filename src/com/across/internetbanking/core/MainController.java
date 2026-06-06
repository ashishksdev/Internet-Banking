package com.across.internetbanking.core;

import com.across.internetbanking.auth.controller.AuthController;
import com.across.internetbanking.core.util.*;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.customer.repository.impl.HashMapCustomeRepository;
import com.across.internetbanking.user.repository.UserRepository;
import com.across.internetbanking.user.repository.impl.HashMapUserRepository;

public class MainController {
    private final CustomerRepository CUSTOMER_DATA = new HashMapCustomeRepository();
    private final UserRepository USER_DATA = new HashMapUserRepository();
    private final AuthController authController = new AuthController(CUSTOMER_DATA, USER_DATA);
    
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