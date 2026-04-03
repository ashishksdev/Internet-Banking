package com.across.internetbanking.auth.service;

import com.across.internetbanking.account.service.OpenBankAccount;

public enum Signup {
    LOGIN {
        @Override
        public void execute(){
            System.out.println("lOGIN attempt");
            Login loginAttempt = new Login();
            loginAttempt.loginUser();
        }
    },

    OPEN {
        @Override
        public void execute(){
            System.out.println("Open Bank account attempt");
            OpenBankAccount bankAccountCreationAttempt = new OpenBankAccount();
            bankAccountCreationAttempt.createBankAccount();
        }
    };
    public abstract void execute();
}