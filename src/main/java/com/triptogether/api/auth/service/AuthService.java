package com.triptogether.api.auth.service;

import com.triptogether.api.auth.dto.SignInRequest;
import com.triptogether.api.auth.dto.SignInResponse;
import com.triptogether.api.auth.dto.SignUpRequest;
import com.triptogether.api.auth.dto.SignUpResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public SignUpResponse signUp(SignUpRequest request) {
        return new SignUpResponse();
    }

    public SignInResponse signIn(SignInRequest request){
        return new SignInResponse();
    }

}
