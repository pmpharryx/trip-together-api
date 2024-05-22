package com.triptogether.api.auth.service;

import com.triptogether.api.auth.dto.SignUpRequest;
import com.triptogether.api.auth.dto.SignUpResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public SignUpResponse signUp(SignUpRequest request) {
        return new SignUpResponse();
    }

}
