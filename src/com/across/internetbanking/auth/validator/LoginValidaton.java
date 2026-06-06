package com.across.internetbanking.auth.validator;

public class LoginValidaton {
    public final void validate(String inputUserId, String inputPassword) {
        // check if userID is present in user databse.
        // If userId is present, check if password matches.
        // If password matches >> provide access to account(if account is active otherwise output the frozen account message.)
        // If either userID not found or password mismatches, throw custom exception with message of Inavlid credentials.
    }
}