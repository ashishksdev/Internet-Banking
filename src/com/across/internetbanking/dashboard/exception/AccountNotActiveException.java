package com.across.internetbanking.dashboard.exception;

public class AccountNotActiveException extends RuntimeException {
    
    public AccountNotActiveException(){}
    public AccountNotActiveException(String message){
        super(message);
    }
    public AccountNotActiveException(String message, Throwable cause){
        super(message, cause);
    }
}