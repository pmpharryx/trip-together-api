package com.triptogether.api.user.controller;

import com.triptogether.api.auth.exception.MissingTokenException;
import com.triptogether.api.auth.exception.SignInErrorException;
import com.triptogether.api.auth.exception.SignUpErrorException;
import com.triptogether.api.auth.utility.JwtUtils;
import com.triptogether.api.common.constant.StatusCode;
import com.triptogether.api.common.dto.ResponseDTO;
import com.triptogether.api.common.exception.FailedException;
import com.triptogether.api.user.dto.UpdateUserProfileRequest;
import com.triptogether.api.user.dto.UserProfileResponse;
import com.triptogether.api.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/get-profile/{userId}")
    public ResponseEntity<ResponseDTO<UserProfileResponse>> getUserProfile(@PathVariable(value = "userId") String userId,
                                                                           @RequestHeader(value = "Authorization", required = false)
                                                                           String authorizationHeader) {

        if(authorizationHeader == null || authorizationHeader.isEmpty()){
            Map<String, String> errors = new HashMap<>();
            errors.put("authorizationHeader", "Authorization header is missing.");
            throw new MissingTokenException("Missing Token Exception", StatusCode.NO_ACCESS_TOKEN, errors);
        }

        JwtUtils.verify();

        ResponseDTO<UserProfileResponse> response = userService.getUserProfile(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update-profile")
    public ResponseEntity<ResponseDTO<?>> updateUserProfile(@Valid @RequestBody UpdateUserProfileRequest request,
                                                            @RequestHeader(value = "Authorization", required = false)
                                                            String authorizationHeader,
                                                            BindingResult bindingResult) {

        if(authorizationHeader == null || authorizationHeader.isEmpty()){
            Map<String, String> errors = new HashMap<>();
            errors.put("authorizationHeader", "Authorization header is missing.");
            throw new MissingTokenException("Missing Authorization Token.", StatusCode.NO_ACCESS_TOKEN, errors);
        }

        JwtUtils.verify();

        if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            throw new FailedException("Update User Profile Failed.", StatusCode.BAD_REQUEST, errors);
        }
        ResponseDTO<?> response = userService.updateUserProfile(request);

        return ResponseEntity.ok(response);
    }
}
