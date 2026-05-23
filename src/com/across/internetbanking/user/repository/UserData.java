package com.across.internetbanking.user.repository;

import java.util.HashMap;

public class UserData {
    HashMap<String,String> userDataTable = new HashMap<>();

    public void update(String userID, String password){
        userDataTable.put(userID,password);
    }

}
