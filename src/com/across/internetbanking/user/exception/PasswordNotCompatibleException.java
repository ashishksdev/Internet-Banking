package com.across.internetbanking.user.exception;

public class PasswordNotCompatibleException extends Exception {
    
    public PasswordNotCompatibleException() {

    }
    public PasswordNotCompatibleException(String message){
        super(message);
    }
    public PasswordNotCompatibleException(String message, Throwable cause){
        super(message, cause);
    }
}
