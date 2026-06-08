package com.across.internetbanking.user.service;

import com.across.internetbanking.core.util.Serial;

public class UserID {
    public String generate(String firstName) {
        Serial serial = new Serial();
        String userID = String.format("%s%d@across", firstName.toLowerCase().trim(), serial.serialCount());
        return userID;
    }
}