package com.triptogether.api.auth.service;

import com.triptogether.api.auth.dto.*;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public SignUpResponse signUp(SignUpRequest request) {
        return new SignUpResponse();
    }

    public SignInResponse signIn(SignInRequest request){
        return new SignInResponse();
    }

    public ChangePasswordResponse changePassword(ChangePasswordRequest request){
        return new ChangePasswordResponse();
    }

}
