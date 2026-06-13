package com.across.internetbanking.auth.controller;

import com.across.internetbanking.core.util.Input;

public class PasswordForm {

    public String promptForPassword(){

        while (true) { 

            System.out.print("Create Password: ");
            String tempPassword = Input.sc.next().trim();

            System.out.print("Confirm password: ");
            String confirmPassword = Input.sc.next().trim();

            if(tempPassword.equals(confirmPassword)){
                return tempPassword;
            }

            System.err.println("Password mismatch! Retry!");
        }
    }
}
