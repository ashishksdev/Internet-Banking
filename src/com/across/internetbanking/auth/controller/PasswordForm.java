package com.across.internetbanking.auth.controller;

import com.across.internetbanking.core.util.Input;

public class PasswordForm {
    public String inputCreatePassword(){
        System.out.print("Create Password: ");
        return Input.sc.next().trim();
    }
    public String inputConfirmPassword(){
        System.out.print("Confirm password: ");
        return Input.sc.next().trim();
    }
}
