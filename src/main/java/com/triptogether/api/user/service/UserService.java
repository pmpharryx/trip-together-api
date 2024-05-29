package com.triptogether.api.user.service;

import com.triptogether.api.common.model.User;
import com.triptogether.api.common.dto.ResponseData;
import com.triptogether.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseData<User> getUserProfile(String userId) {
        Optional<User> user = userRepository.findById(UUID.fromString(userId));
        return ResponseData.<User>responseDataBuilder()
                    .data(user.orElse(null))
                    .build();
    }
}
