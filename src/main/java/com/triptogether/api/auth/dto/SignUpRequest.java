package com.triptogether.api.auth.dto;

import com.triptogether.api.auth.validator.ValidUsername;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "username is mandatory")
    @ValidUsername()
    private String username;

    @NotBlank(message = "password is mandatory")
    private String password;

    @NotBlank(message = "mobileNo is mandatory")
    private String mobileNo;

}
