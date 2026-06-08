package com.across.internetbanking.customer.dto;

public record CustomerPersonalInfoDTO(
    String uniqueID,
    String firstName,
    String lastName,
    char gender,
    int age,
    long mobileNo)
{}
