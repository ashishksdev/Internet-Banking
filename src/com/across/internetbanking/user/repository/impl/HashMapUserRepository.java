package com.across.internetbanking.user.repository.impl;

import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.repository.UserRepository;
import java.util.HashMap;

public class HashMapUserRepository implements UserRepository {
    private final HashMap<String, User> userDataTable = new HashMap<>();

    @Override
    public void update(User user){
        userDataTable.put(user.userID, user);
    }

    @Override
    public boolean exists(String userID){
        return userDataTable.containsKey(userID);
    }

    @Override
    public boolean validate(String userID, String password){
        return ((userDataTable.get(userID)).passwordMatch(password));
    }

    @Override
    public User getUser(String userID){
        return userDataTable.get(userID);
    }
}