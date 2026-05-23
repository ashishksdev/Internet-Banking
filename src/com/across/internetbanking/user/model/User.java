package com.across.internetbanking.user.model;

import java.util.Scanner;

public class User {
    public String userID;
    public String password;

    public String genUserID(String firstName, int serial){
        userID = String.format("%s%d@across", firstName, serial);
        return userID;
    }

    public void createPassword(){
        String tempPassword;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Create password: ");
            tempPassword = sc.next();

            if(tempPassword.length() >= 4){
                System.out.print("Confirm password: ");
                String confirmPassword = sc.next();

                if(tempPassword.equals(confirmPassword)){
                    password = confirmPassword;
                    System.out.println("Password succesfully created!\nDo not share your password, unlesh you've got enough money to get bankcorrupted!!");
                } else {
                    System.err.println("Password mismatch! Retry!");
                    createPassword();
                }
            } else{
                System.err.println("Password must be atleat of 4 digits. Retry!");
                createPassword();
            }
        }
    }
}
