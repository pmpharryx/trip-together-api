package com.triptogether.api.common.exception;

import com.triptogether.api.common.constant.StatusCode;
import com.triptogether.api.common.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO<?>> handleUserNotFoundException(UserNotFoundException ex){
        ResponseDTO<?> response =  ResponseDTO.responseBuilder()
                .statusCode(StatusCode.SIGN_UP_ERROR_1)
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UpdateUserProfileErrorException.class)
    public ResponseEntity<ResponseDTO<?>> handleUpdateUserProfileErrorException(UpdateUserProfileErrorException ex){
        ResponseDTO<?> response =  ResponseDTO.responseBuilder()
                .statusCode(StatusCode.SIGN_UP_ERROR_1)
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
