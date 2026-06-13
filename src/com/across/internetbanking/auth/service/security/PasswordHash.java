package com.across.internetbanking.auth.service.security;

public interface PasswordHash {
    public String generateSalt();
    public String hashPassword(String password, String salt);
}