package com.across.internetbanking.auth.service;

public enum AuthType {
    LOGIN {
        @Override
        void execute(AuthenticationService authService){
            authService.login.loginUser();
        }
    },

    OPEN {
        @Override
        void execute(AuthenticationService authService){
            authService.signup.registerCustomer(authService);
        }
    };
    
    
    abstract void execute(AuthenticationService authService);
}