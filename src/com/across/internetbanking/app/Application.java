package com.across.internetbanking.app;

import java.util.Scanner;
import com.across.internetbanking.auth.service.Signup;

public class Application {

    static void initiateSignup(int attemptCount) {
        // restricting failed attempt.
        if(attemptCount>5){
            System.out.println("You have reached the limit!\nTry again later!");
            return;
        }

        // User input for signup(login/open) action.
        System.out.print("LOGIN | OPEN\n>> ");
        Scanner sc = new Scanner(System.in);
        String UserSignupRequest = sc.next().trim().toUpperCase(); // User Signup request string.

        try {
            Signup request = Signup.valueOf(UserSignupRequest); // Convert UserSignupRequest to Enum from string, for request verification.
            request.execute();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please type LOGIN or OPEN"); // Invalid Signup request message.
            System.out.printf("Attempt left: %d\n\n", (5-attemptCount)); // Attempt left message.
            initiateSignup(attemptCount+1); // Reattempt signup.
            sc.close();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Across!\nYour seamless internet banking.\n"); // greets
        initiateSignup(1); // Initiate Signup (Login or Open Bank Account)
        
    }
}