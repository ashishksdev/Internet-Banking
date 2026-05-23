package com.across.internetbanking.customer.model;

import com.across.internetbanking.user.model.User;
import java.util.Scanner;

public class Customer {
    private String firstName; private String lastName;
    private char gender;
    private int age;
    private long mobileNo;
    private final String uniqueID;
    public User user = new User();

    private static final Scanner sc =  new Scanner(System.in);

    {
        System.out.print("Enter Unique ID: ");
        uniqueID = sc.next();
        sc.nextLine();

        // Validate uniqueId is already in system or not.
        
    }

    public Customer collectCustomerInfo(){

        System.out.print("Full name: ");
        firstName = sc.next();
        sc.nextLine();

        System.out.print("Gender: ");
        gender = sc.next().charAt(0);

        System.out.print("Age: ");
        age = sc.nextInt();

        System.out.print("Mobile: ");
        mobileNo = sc.nextLong();
        
        return this;
    }

    public void generateUser(){
        user.genUserID(firstName, 700);
        System.out.printf("%n>> Your User ID: %s%n", user.userID);
        user.createPassword();
    }

    public String uniqueID(){
        return this.uniqueID;
    }
}