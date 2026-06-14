package com.across.internetbanking.auth.service.security.impl;

import com.across.internetbanking.auth.service.security.PasswordHash;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class SimpleHasher implements PasswordHash {
    
    @Override
    public String generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] saltByte = new byte[16];
        random.nextBytes(saltByte);
        
        return Base64.getEncoder().encodeToString(saltByte);
    }

    @Override
    public String hashPassword(String password, String salt){
        String temp = password+salt;
        String hashedPassword = (UUID.nameUUIDFromBytes(temp.getBytes(StandardCharsets.UTF_8))).toString();
        return hashedPassword;
    }
        
}