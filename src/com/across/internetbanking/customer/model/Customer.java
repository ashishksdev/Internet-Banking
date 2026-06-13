package com.across.internetbanking.customer.model;

public record Customer(
    String uniqueID,
    String name,
    Gender gender,
    int age,
    String mobileNo)
{}