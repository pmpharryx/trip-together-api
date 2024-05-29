package com.triptogether.api.auth.controller;

import com.triptogether.api.auth.dto.*;
import com.triptogether.api.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<Response> signUp(@RequestBody SignUpRequest request) {
        Response response = authService.signUp(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<ResponseData<SignInResponse>> signIn(@RequestBody SignInRequest request) {
        ResponseData<SignInResponse> response = authService.signIn(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/change-password")
    public ResponseEntity<Response> changePassword(@RequestBody ChangePasswordRequest request) {
        Response response = authService.changePassword(request);
        return ResponseEntity.ok(response);
    }


}
