package com.triptogether.api.auth.service;

import com.triptogether.api.auth.dto.*;
import com.triptogether.api.common.dto.ResponseData;
import com.triptogether.api.common.model.User;
import com.triptogether.api.auth.repository.AuthRepository;
import com.triptogether.api.common.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public Response signUp(SignUpRequest request) {

        authRepository.save(new User(request.getUsername(), request.getPassword(), request.getMobileNo()));
        return Response.responseBuilder()
                .statusMessage("Sign up successfully.")
                .build();
    }

    public ResponseData<SignInResponse> signIn(SignInRequest request){
        return ResponseData.<SignInResponse>responseDataBuilder()
                .statusMessage("Sign in successfully.")
                .data(new SignInResponse())
                .build();
    }

    public Response changePassword(ChangePasswordRequest request) {
        return Response.responseBuilder()
                .statusMessage("Changing password successfully.")
                .build();
    }

}
