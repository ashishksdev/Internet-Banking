package com.across.internetbanking.core.util;

public record Serial() {
    private static int currentSerial = 700;

    public int serialCount() {
        return ++currentSerial;
    }
}
