package com.triptogether.api.auth.controller;

import com.triptogether.api.auth.dto.ChangePasswordRequest;
import com.triptogether.api.auth.dto.SignInRequest;
import com.triptogether.api.auth.dto.SignInResponse;
import com.triptogether.api.auth.dto.SignUpRequest;
import com.triptogether.api.auth.exception.ChangePasswordErrorException;
import com.triptogether.api.auth.service.AuthService;
import com.triptogether.api.common.dto.ResponseDTO;
import com.triptogether.api.auth.exception.MissingTokenException;
import com.triptogether.api.auth.exception.SignInException;
import com.triptogether.api.auth.exception.SignUpException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            throw new SignUpException("Sign-Up Error Exception",errors);
        }
        ResponseDTO<?> response = authService.signUp(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<ResponseDTO<SignInResponse>> signIn(@Valid @RequestBody SignInRequest request,
                                                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            throw new SignInException("Sign-In Error Exception", errors);
        }
        ResponseDTO<SignInResponse> response = authService.signIn(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/change-password")
    public ResponseEntity<ResponseDTO<?>> changePassword(@Valid @RequestBody ChangePasswordRequest request,
                                                         @RequestHeader(value = "Authorization", required = false)
                                                         String authorizationHeader, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            throw new ChangePasswordErrorException("Change Password Error Exception", errors);
        }

        if(authorizationHeader == null){
            Map<String, String> errors = new HashMap<>();
            errors.put("authorizationHeader", "Authorization token is missing.");
            throw new MissingTokenException("Missing Token Exception", errors);
        }

        ResponseDTO<?> response = authService.changePassword(request);
        return ResponseEntity.ok(response);
    }
}
