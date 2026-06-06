package com.across.internetbanking.user.service;

import com.across.internetbanking.core.util.Serial;
import com.across.internetbanking.customer.model.Customer;
import com.across.internetbanking.user.exception.PasswordNotCompatibleException;
import com.across.internetbanking.user.model.User;
import com.across.internetbanking.user.validator.IsCompatiblePassword;

public class GenerateUser {
    Customer customer;
    Serial serial = new Serial();

    public GenerateUser(){}
    public GenerateUser(Customer customer){
        this.customer = customer;
    }

    public String userID() {
        String userID = String.format("%s%d@across", customer.firstName(), serial.serialCount());
        return userID;
    }

    public boolean compatiblePassword(String tempPassword) throws PasswordNotCompatibleException {
        boolean canBePassword;

        // Validaete if input password is compatible tp be User ID pasword.
        IsCompatiblePassword isCompatiblePassword = new IsCompatiblePassword();
        canBePassword = isCompatiblePassword.validate(tempPassword);

        if(!canBePassword){
            throw new PasswordNotCompatibleException("Password must be of minimum length 4.\nAlso it must contains atleast one Upper Case, Lowercase, Digits and symbols.");
        } 
        
        return true;
    }

    public User createUser(String userID, String password){
        User user = new User(userID, password);
        return user;
    }

    public boolean eligiblePassword(String tempPassword, String confirmPassword){
        return tempPassword.equals(confirmPassword);
    }
}
