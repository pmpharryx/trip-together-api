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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.triptogether.api.auth.utility.JwtUtils.createToken;
import static com.triptogether.api.auth.utility.JwtUtils.getUserId;


@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    // method for password encoding
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // method for password verifying
    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public ResponseDTO<?> signUp(SignUpRequest request) {

        // Pre-check for existing username
        Optional<User> existingUserByUsername = authRepository.findByUsername(request.getUsername());
        if(existingUserByUsername.isPresent()){
            Map<String, String> errors = new HashMap<>();
            errors.put("username", "Username already exists");
            throw new SignUpDatabaseConstrainViolationException("Sign-up database constraint violation", errors);
        }

            throw new SignUpDatabaseConstrainViolationException("Sign-up database constraint violation", errors);
        }
            // Pre-check for existing email
            Optional<User> existingUserByEmail = authRepository.findByEmail(request.getEmail());
            if(existingUserByEmail.isPresent()){
                Map<String, String> errors = new HashMap<>();
                errors.put("email", "User with provided email address is already exists");
            //BCrypt encode password
            String encodedPassword = passwordEncoder.encode(request.getPassword());

            // Save user
            authRepository.save(new User(request.getUsername(), encodedPassword, request.getEmail()));

            return ResponseDTO.responseBuilder()
                    .statusMessage("Sign up successfully.")
                    .data(null)
                    .build();

        }catch(Exception e){
            return ResponseDTO.responseBuilder()
                    .statusMessage("Sign up failed.")
                    .data(null)
                    .build();
        }
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

        // verify password
        boolean passwordIsValid = verifyPassword(request.getPassword(), user.getPassword());

        //Check password
        if(!passwordIsValid){
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

        // verify password
        boolean oldPasswordIsValid = verifyPassword(request.getOldPassword(), user.getPassword());

        // old password does not match
        if(!oldPasswordIsValid){
            Map<String, String> errors = new HashMap<>();
            errors.put("oldPassword", "Invalid previous password.");
            throw new ChangePasswordErrorException("Changing password failed.",errors);
        }

        // encode new password
        String encodedNewPassword = encodePassword(request.getNewPassword());

        // update new password
        authRepository.updatePassword(user.getUserId(),encodedNewPassword);

        return ResponseDTO.responseBuilder()
                .statusMessage("Changing password successfully.")
                .build();
    }
}
