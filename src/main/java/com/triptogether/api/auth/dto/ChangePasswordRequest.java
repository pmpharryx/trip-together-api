package com.triptogether.api.auth.dto;

import com.triptogether.api.common.validator.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {

    @NotBlank
    @ValidPassword
    private String oldPassword;

    @NotBlank
    @ValidPassword
    private String newPassword;
}
