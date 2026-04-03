package com.across.internetbanking.auth.service;

import com.across.internetbanking.auth.model.UserID;
import java.util.Scanner;

class Login {
    void loginUser(){
        // Input login credentials (userID and Password) for login.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userIDInputStr = sc.next().trim().toLowerCase(); // UserID input in String format.
        String inputPassword = sc.next(); // userID password input.
        sc.close();

        if(userIDInputStr.contains("@across")){
            UserID inputUserID = new UserID();
            // inputUserID
        } else { System.out.println("Invalid credentials."); }
    }
}