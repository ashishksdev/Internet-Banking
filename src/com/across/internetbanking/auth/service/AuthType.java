package com.across.internetbanking.auth.service;

public enum AuthType {
    
    LOGIN {
        @Override
        public boolean execute(Signup SIGNUP, Login LOGIN){
            return LOGIN.loginUser();
        }
    },

    OPEN {
        @Override
        public boolean execute(Signup SIGNUP, Login LOGIN){
            return SIGNUP.registerCustomer();
        }
    };
    
    public abstract boolean execute(Signup SIGNUP, Login LOGIN);

}