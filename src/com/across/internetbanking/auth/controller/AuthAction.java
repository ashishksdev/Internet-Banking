package com.across.internetbanking.auth.controller;

import com.across.internetbanking.auth.service.Signup;
import com.across.internetbanking.user.model.User;

public enum AuthAction {
    
    LOGIN {
        @Override
        public User execute(Signup SIGNUP, Login LOGIN){
            return LOGIN.loginUser();
        }
    },

    OPEN {
        @Override
        public User execute(Signup SIGNUP, Login LOGIN){
            return SIGNUP.onboardClient();
        }
    };
    
    public abstract User execute(Signup SIGNUP, Login LOGIN);
}