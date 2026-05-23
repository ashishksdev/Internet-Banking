package com.across.internetbanking.auth.service;

import com.across.internetbanking.customer.repository.CustomerData;
import com.across.internetbanking.user.repository.UserData;
import java.util.Scanner;

public class AuthenticationService {
    public final Login login = new Login();
    public final Signup signup = new Signup();
    public CustomerData customerData = new CustomerData();
    public UserData userData = new UserData();
    private final Scanner sc = new Scanner(System.in);

    public void startAuthFlow(AuthenticationService authService, int attemptCount) {

        // Restrict number of failed attempts.
        if(attemptCount>5){
            System.out.println("You have reached the maximum limit!\nTry again later!");
            return;
        }

        // User input for signup(login/open) action.
        System.out.print("LOGIN | OPEN\n>> ");
        String actionInput = sc.next().trim().toUpperCase(); // User Signup request string.

        try {
            AuthType request = AuthType.valueOf(actionInput); // Convert UserSignupRequest to Enum from string, for request verification.
            request.execute(authService); // Execute the request.
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please type LOGIN or OPEN"); // Invalid Signup request message.
            System.out.printf("Attempt left: %d\n\n", (5-attemptCount)); // Attempt left message.
            startAuthFlow(authService, attemptCount+1); // Reattempt signup.
        }

        startAuthFlow(authService, attemptCount);
    }
}