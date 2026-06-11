package com.across.internetbanking.auth.validator;

import com.across.internetbanking.auth.dto.LoginDTO;
import com.across.internetbanking.user.repository.UserRepository;

public class LoginValidation {
    UserRepository userRepository;

    public LoginValidation(UserRepository USER_DATA){
        this.userRepository = USER_DATA;
    }

    public boolean validateUser(LoginDTO loginDTO) {
        return userRepository.exists(loginDTO.userIDInput());
    }

    public boolean validateCredentials(LoginDTO loginDTO){
        return userRepository.validate(loginDTO.userIDInput(), loginDTO.passwordInput());
    }
}