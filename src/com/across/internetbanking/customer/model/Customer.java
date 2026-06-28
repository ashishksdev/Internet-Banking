package com.across.internetbanking.customer.model;

public class Customer{
    private final String uniqueID;
    private String name;
    private Gender gender;
    private int age;
    private String mobileNo;
    private String userID;
    private String accountNumber;

    public Customer (
        String uniqueID,
        String name,
        Gender gender,
        int age,
        String mobileNo) {

        this.uniqueID = uniqueID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mobileNo = mobileNo;
    }

    public String customerID(){
        return uniqueID;
    }
    public String name(){
        return name;
    }

    public void linkAccount(String acconuntNumber){
        this.accountNumber = acconuntNumber;
    }

    public void linkUser(String userID){
        this.userID = userID;
    }
}