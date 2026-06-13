package com.across.internetbanking.core;

import com.across.internetbanking.auth.controller.AuthController;
import com.across.internetbanking.core.exception.SessionLimitReachedException;
import com.across.internetbanking.core.util.*;
import com.across.internetbanking.customer.repository.CustomerRepository;
import com.across.internetbanking.customer.repository.impl.HashMapCustomerRepository;
import com.across.internetbanking.user.repository.UserRepository;
import com.across.internetbanking.user.repository.impl.HashMapUserRepository;

public class MainController {
    private final CustomerRepository CUSTOMER_DATA = new HashMapCustomerRepository();
    private final UserRepository USER_DATA = new HashMapUserRepository();
    private final AuthController authController = new AuthController(CUSTOMER_DATA, USER_DATA);
    
    private int authCycleCount = 1;

    public MainController(){}

    public void start(){

        try {
            
            while(authCycleCount <= AppConstants.MAX_AUTH_CYCLE){
                authController.start();
                authCycleCount++;
            }
            sessionExpireMessage(); // Session expire message
            
        } catch (SessionLimitReachedException slre) {
            sessionExpireMessage(); // Session expire message
        }
        
    }
    
    private void sessionExpireMessage(){
        System.out.println("Session expired!");
    }

}