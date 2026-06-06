package com.across.internetbanking.user.repository;

// import java.util.HashMap;

// public class UserRepository {
//     HashMap<String,String> userDataTable = new HashMap<>();

//     public void update(String userID, String password){
//         userDataTable.put(userID,password);
//     }

// }

public interface UserRepository {
    void update(String userID, String password);
    boolean exists(String useId);
}