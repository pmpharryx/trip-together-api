package com.triptogether.api.auth.dto;

import com.triptogether.api.common.validator.ValidPassword;
import com.triptogether.api.common.validator.ValidUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "Username is mandatory.")
    @ValidUsername()
    private String username;

    @NotBlank(message = "Password is mandatory.")
    @ValidPassword
    private String password;

    @NotBlank(message = "Email is mandatory.")
    @Email(message = "Invalid email format.")
    private String email;

}
