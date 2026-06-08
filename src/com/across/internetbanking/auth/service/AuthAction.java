package com.across.internetbanking.auth.service;

public enum AuthAction {
    
    LOGIN {
        @Override
        public boolean execute(Signup SIGNUP, Login LOGIN){
            return LOGIN.loginUser();
        }
    },

    OPEN {
        @Override
        public boolean execute(Signup SIGNUP, Login LOGIN){
            return SIGNUP.onboardClient();
        }
    };
    
    public abstract boolean execute(Signup SIGNUP, Login LOGIN);
}