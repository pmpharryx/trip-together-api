package com.triptogether.api.common.exception;

import com.triptogether.api.common.constant.StatusCode;
import com.triptogether.api.common.dto.ResponseDTO;
import com.triptogether.api.common.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FailedException.class)
    public ResponseEntity<ResponseDTO<?>> handleFailedException(FailedException ex) {
        ResponseDTO<?> response = ResponseDTO.<User>responseBuilder()
                .statusCode(StatusCode.BAD_REQUEST)
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDTO<?>> handleNotFoundException(NotFoundException ex) {
        ResponseDTO<?> response = ResponseDTO.responseBuilder()
                .statusCode(StatusCode.SUCCESS)
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
