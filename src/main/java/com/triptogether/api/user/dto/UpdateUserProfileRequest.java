package com.triptogether.api.user.dto;

import com.triptogether.api.common.validator.AtLeastOneOf;
import com.triptogether.api.common.validator.ValidEmailIfNotNull;
import com.triptogether.api.common.validator.ValidUsernameIfNotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
@AtLeastOneOf(fields = {"username", "email"})
public class UpdateUserProfileRequest {

    @NotBlank(message = "User ID is mandatory.")
    @NotNull
    private UUID userId;

    @ValidUsernameIfNotNull
    private String username;

    @ValidEmailIfNotNull
    private String email;
}
