package com.across.internetbanking.auth.exception;

public class UIDAlreadyExistsException extends RuntimeException {

    public UIDAlreadyExistsException() {

    }
    public UIDAlreadyExistsException(String message){
        super(message);
    }
    public UIDAlreadyExistsException(String message, Throwable cause){
        super(message, cause);
    }
    
}
