package com.across.internetbanking.user.repository.impl;

import com.across.internetbanking.user.repository.UserRepository;
import java.util.HashMap;

public class HashMapUserRepository implements UserRepository {
    private final HashMap<String,String> userDataTable = new HashMap<>();

    @Override
    public void update(String userID, String password){
        userDataTable.put(userID,password);
    }

    @Override
    public boolean exists(String userID){
        return userDataTable.containsKey(userID);
    }
}
