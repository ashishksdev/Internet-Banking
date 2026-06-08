package com.across.internetbanking.user.factory;

import com.across.internetbanking.user.model.User;

public class UserFactory {

    public User create(String userID, String password){
        User newUser = new User(userID, password);
        return newUser;
    }
}
