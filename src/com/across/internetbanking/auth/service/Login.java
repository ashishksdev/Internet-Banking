package com.across.internetbanking.auth.service;

import com.across.internetbanking.user.validator.LoginValidaton;
import java.util.Scanner;

class Login {
    void loginUser(){
        // Input login credentials (userID and Password) for login.
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("User ID: ");
            String inputUserID = sc.next().trim().toLowerCase(); // UserID input in String format.
            System.out.print("Password: ");
            String inputPassword = sc.next(); // userID's password input.

            try {
                new LoginValidaton().validate();
            } catch (IllegalAccessError e) {

            }
        }
    }
}  