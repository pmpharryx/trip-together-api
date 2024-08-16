package com.triptogether.api.user.dto;

import com.triptogether.api.common.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserProfileResponse {

    private UUID userId;

    private String username;

    private String email;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;

    public static UserProfileResponse fromUser (User user) {

        UserProfileResponse userProfile = new UserProfileResponse();
        userProfile.setUserId(user.getUserId());
        userProfile.setUsername(user.getUsername());
        userProfile.setEmail(user.getEmail());
        userProfile.setCreatedBy(user.getCreatedBy());
        userProfile.setCreatedAt(user.getCreatedAt());
        userProfile.setUpdatedBy(user.getUpdatedBy());
        userProfile.setUpdatedAt(user.getUpdatedAt());

        return userProfile;
    }
}
