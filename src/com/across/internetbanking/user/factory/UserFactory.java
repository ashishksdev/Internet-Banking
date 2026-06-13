package com.across.internetbanking.user.factory;

import com.across.internetbanking.auth.service.security.PasswordHash;
import com.across.internetbanking.user.model.User;

public class UserFactory {

    public User create(String userID, String hashedPassword, String salt, PasswordHash passwordHash){
        User newUser = new User(userID, hashedPassword, salt, passwordHash);
        return newUser;
    }
}
