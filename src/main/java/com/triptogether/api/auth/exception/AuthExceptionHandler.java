package com.triptogether.api.auth.exception;


import com.triptogether.api.common.constant.StatusCode;
import com.triptogether.api.common.dto.ResponseDTO;
import com.triptogether.api.common.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(DatabaseConstrainViolationException.class)
    public ResponseEntity<ResponseDTO<?>> handleSignUpException(DatabaseConstrainViolationException ex){
        ResponseDTO<?> response =  ResponseDTO.<User>responseBuilder()
                .statusCode(ex.getStatusCode())
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingTokenException.class)
    public ResponseEntity<ResponseDTO<?>> handleMissingHeaderException(MissingTokenException ex){
        ResponseDTO<?> response = ResponseDTO.responseBuilder()
                .statusCode(ex.getStatusCode())
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
