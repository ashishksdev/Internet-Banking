package com.across.internetbanking.user.repository;

import com.across.internetbanking.user.model.User;

public interface UserRepository {
    void update(User user);
    boolean exists(String userID);
    boolean validate(String userID, String password);
    User getUser(String userID);
}