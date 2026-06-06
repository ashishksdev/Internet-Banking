package com.across.internetbanking.user.validator;

public class IsCompatiblePassword {
    public boolean validate(String tempPassword) {

        if(tempPassword.length() < 4){
            return false;
        }

        boolean containsUppercase = tempPassword.matches(".*[A-Z].*"); // validate if contains at least one capital alphabet letter.
        boolean containsLowercase = tempPassword.matches(".*[a-z].*"); // validate if contains at least one small alphabet letter.
        boolean containsDigit = tempPassword.matches(".*[0-9].*"); // validate if contains at least one digit.
        boolean containsSymbol = tempPassword.matches(".*[^a-zA-Z0-9].*"); // validate if contains at least one symbol.

        boolean isCompatiblePassword = containsUppercase && containsLowercase && containsDigit && containsSymbol;
        return isCompatiblePassword;
    }
}
