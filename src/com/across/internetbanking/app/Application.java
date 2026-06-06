package com.across.internetbanking.app;

import com.across.internetbanking.core.MainController;
import com.across.internetbanking.core.util.AppConstants;

public class Application {

    public static void main(String[] args) {

        System.out.println(AppConstants.WELCOME_MESSAGE); // Welcome message.
        MainController mainController = new MainController();
        mainController.start();
    
    }
}