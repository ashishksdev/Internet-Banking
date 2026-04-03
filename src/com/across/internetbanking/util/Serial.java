package com.across.internetbanking.util;

public record Serial() {
    private static int currentSerial = 2700;

    public int serialCount() {
        return ++currentSerial;
    }
}
