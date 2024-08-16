package com.triptogether.api.auth.controller;

import com.triptogether.api.auth.dto.SignUpRequest;
import com.triptogether.api.auth.service.AuthService;
import com.triptogether.api.common.exception.FailedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@WebMvcTest(AuthController.class)
@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    private static Stream<Arguments> provideTestData(){
        return Stream.of(
                Arguments.of(new SignUpRequest("","ValidPassword1!","user@example.com"),"Username is mandatory."),
                Arguments.of(new SignUpRequest("invalidUsername$","ValidPassword1!","user@example.com"),"Username must only contains alphabet characters, numbers, and underscores between 1 - 16 characters long."),
                Arguments.of(new SignUpRequest("validUsername","","user@example.com"),"Password is mandatory."),
                Arguments.of(new SignUpRequest("validUsername","too","user@example.com"),"Password must be between 4 to 30 characters long."),
                Arguments.of(new SignUpRequest("validUsername","ValidPassword1!",""),"invalid-email,Invalid email format.")
        );
    }

    @Test
    void testSignUp_shouldSuccessfullySignUp_whenXXX(){

        // Arrange
        SignUpRequest mockRequest = new SignUpRequest("validUsername","ValidPassword1!","user@example.com");
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        ResponseEntity<?> response = authController.signUp(mockRequest, bindingResult);

        // Assert
        verify(authService, times(1)).signUp(mockRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @ParameterizedTest()
    @MethodSource("provideTestData")
    void testSignUpFailed_shouldThrowException_whenRequestIsInvalid(SignUpRequest mockRequest, String expectedError) {

        // Arrange
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.getFieldErrors()).thenReturn(List.of(new FieldError("objectName", "fieldName", "error message")));

        // Act
        FailedException exception = assertThrows(FailedException.class, () ->
                authController.signUp(mockRequest, bindingResult));

        // Assert
        assertNotNull(exception);
        assertEquals("Sign-Up Error Exception", exception.getMessage());

    }

}
