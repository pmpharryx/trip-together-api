package com.triptogether.api.auth.dto;

import com.triptogether.api.common.validator.ValidUsername;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {

    @NotBlank(message = "Username is mandatory")
    @ValidUsername
    private String username;

    @NotBlank(message = "password is mandatory")
    private String password;

}
