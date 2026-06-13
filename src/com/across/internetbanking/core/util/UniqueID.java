package com.across.internetbanking.core.util;

import java.util.UUID;

public class UniqueID {

    public static String get(){
        return UUID.randomUUID().toString();
    }
}