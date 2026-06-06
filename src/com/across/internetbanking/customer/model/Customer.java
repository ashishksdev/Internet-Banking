package com.across.internetbanking.customer.model;

public record Customer(
    String uniqueID,
    String firstName, String lastName,
    char gender,
    int age,
    long mobileNo)
{}