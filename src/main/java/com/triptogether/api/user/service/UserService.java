package com.triptogether.api.user.service;

import com.triptogether.api.common.constant.StatusCode;
import com.triptogether.api.common.dto.ResponseDTO;
import com.triptogether.api.common.model.User;
import com.triptogether.api.user.dto.UpdateUserProfileRequest;
import com.triptogether.api.user.dto.UserProfileResponse;
import com.triptogether.api.common.exception.UserNotFoundException;
import com.triptogether.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseDTO<UserProfileResponse> getUserProfile(String userId) {
        Optional<User> optionalUser = userRepository.findById(UUID.fromString(userId));

        if(optionalUser.isEmpty()){
            Map<String, String> errors = new HashMap<>();
            errors.put("userId", "Cannot find the user with provided userId.");
            throw new UserNotFoundException("User Not Found Exception",errors);
        }
        User user = optionalUser.get();

        UserProfileResponse userProfile = UserProfileResponse.fromUser(user);

        return ResponseDTO.<UserProfileResponse>responseBuilder()
                    .data(userProfile)
                    .build();
    }

    public ResponseDTO<?> updateUserProfile(UpdateUserProfileRequest request){

        if(request.getUsername() != null){
            userRepository.updateUsername(request.getUserId(), request.getUsername());
        }
        if(request.getEmail() != null){
            userRepository.updateEmail(request.getUserId(),request.getEmail());
        }

        return ResponseDTO.responseBuilder()
                .statusMessage("Update successfully.")
                .build();
    }
}
