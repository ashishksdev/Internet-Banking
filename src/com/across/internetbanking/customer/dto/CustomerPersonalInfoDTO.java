package com.across.internetbanking.customer.dto;

import com.across.internetbanking.customer.model.Gender;

public record CustomerPersonalInfoDTO(
    String uniqueID,
    String name,
    Gender gender,
    int age,
    String mobileNo)
{}