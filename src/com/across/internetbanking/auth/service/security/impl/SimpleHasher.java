package com.across.internetbanking.auth.service.security.impl;

import com.across.internetbanking.auth.service.security.PasswordHash;
import com.across.internetbanking.core.util.UniqueID;
import java.util.UUID;

public class SimpleHasher implements PasswordHash {
    
    @Override
    public String generateSalt(){
        String rawID = UniqueID.get().replace("-","");
        String salt = (rawID.length() > 16) ? rawID.substring(0,16) : rawID;
        return salt;
    }

    @Override
    public String hashPassword(String password, String salt){
        String temp = password+salt;
        String hashedPassword = (UUID.nameUUIDFromBytes(temp.getBytes())).toString();
        System.out.println(">>>> " + hashedPassword);
        return hashedPassword;
    }
        
}