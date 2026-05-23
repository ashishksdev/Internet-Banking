package com.across.internetbanking.util;

public record Serial() {
    private static int currentSerial = 700;

    public int serialCount() {
        return ++currentSerial;
    }
}
