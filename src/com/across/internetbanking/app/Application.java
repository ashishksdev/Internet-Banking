package com.across.internetbanking.app;

import com.across.internetbanking.auth.service.AuthenticationService;

public class Application {

    private static final AuthenticationService authService = new AuthenticationService();

    public static void main(String[] args) {

        System.out.println("Welcome to Across!\n"); // Welcome message.
        authService.startAuthFlow(authService, 1); // Initiate Authentication Flow (Login or Open bank account)
    }
}