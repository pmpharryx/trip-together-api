package com.triptogether.api.auth.service;

import com.triptogether.api.auth.dto.ChangePasswordRequest;
import com.triptogether.api.auth.dto.SignInRequest;
import com.triptogether.api.auth.dto.SignInResponse;
import com.triptogether.api.auth.dto.SignUpRequest;
import com.triptogether.api.auth.exception.ChangePasswordErrorException;
import com.triptogether.api.auth.repository.AuthRepository;
import com.triptogether.api.auth.utility.JwtUtils;
import com.triptogether.api.common.dto.ResponseDTO;
import com.triptogether.api.auth.exception.InvalidSignInDataException;
import com.triptogether.api.auth.exception.SignUpDatabaseConstrainViolationException;
import com.triptogether.api.common.model.User;
import com.triptogether.api.common.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.triptogether.api.auth.utility.JwtUtils.createToken;
import static com.triptogether.api.auth.utility.JwtUtils.getUserId;


@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public ResponseDTO<?> signUp(SignUpRequest request) {

        // Pre-check for existing username
        Optional<User> existingUserByUsername = authRepository.findByUsername(request.getUsername());
        if(existingUserByUsername.isPresent()){
            Map<String, String> errors = new HashMap<>();
            errors.put("username", "Username already exists");
            throw new SignUpDatabaseConstrainViolationException("Sign-up database constraint violation", errors);
        }

        // Pre-check for existing mobile number
        Optional<User> existingUserByMobileNo = authRepository.findByMobileNo(request.getMobileNo());
        if(existingUserByMobileNo.isPresent()){
            Map<String, String> errors = new HashMap<>();
            errors.put("mobile_no", "User with provided phone number is already exists");
            throw new SignUpDatabaseConstrainViolationException("Sign-up database constraint violation", errors);
        }

        // Save user
        authRepository.save(new User(request.getUsername(), request.getPassword(), request.getMobileNo()));
        return ResponseDTO.responseBuilder()
                .statusMessage("Sign up successfully.")
                .data(null)
                .build();
    }

    public ResponseDTO<SignInResponse> signIn(SignInRequest request) {

        //Find user
        Optional<User> optionalUser = authRepository.findByUsername(request.getUsername());
        if (optionalUser.isEmpty()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("username", "User with provided username is not exist.");
            throw new UserNotFoundException("Sign in failed", errors);
        }
        User user = optionalUser.get();

        //Check password
        if(!user.getPassword().equals(request.getPassword())){
            Map<String, String> errors = new HashMap<>();
            errors.put("password", "Invalid password.");
            throw new InvalidSignInDataException("Sign in failed", errors);
        }
        String token = createToken(user.getUserId());
        SignInResponse response = new SignInResponse(token);

        return ResponseDTO.<SignInResponse>responseBuilder()
                .statusMessage("Sign in successfully.")
                .data(response)
                .build();
        }

    public ResponseDTO<?> changePassword(ChangePasswordRequest request) {

        JwtUtils.verify();

        // Get user by userId inside JWT token
        // Modify this part to add Administration Role
        Optional<User> optionalUser = authRepository.findById(getUserId());// Not sure

        // Cannot find user
        if(optionalUser.isEmpty()){
            Map<String, String> errors = new HashMap<>();
            errors.put("userId", "Cannot find the user with provided userId.");
            throw new UserNotFoundException("Changing password failed. ",errors);
        }
        User user = optionalUser.get();

        // Old password does not match
        if(!user.getPassword().equals(request.getOldPassword())){
            Map<String, String> errors = new HashMap<>();
            errors.put("oldPassword", "Invalid previous password.");
            throw new ChangePasswordErrorException("Changing password failed.",errors);
        }

        // Update new password
        authRepository.updatePassword(user.getUserId(),request.getNewPassword());

        return ResponseDTO.responseBuilder()
                .statusMessage("Changing password successfully.")
                .build();
    }
}
