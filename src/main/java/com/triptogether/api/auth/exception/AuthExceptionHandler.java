package com.triptogether.api.auth.exception;


import com.triptogether.api.auth.constant.StatusCode;
import com.triptogether.api.common.dto.ResponseDTO;
import com.triptogether.api.common.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(SignUpErrorException.class)
    public ResponseEntity<ResponseDTO<?>> handleSignUpException(SignUpErrorException ex){
        ResponseDTO<?> response =  ResponseDTO.<User>responseBuilder()
                .statusCode(StatusCode.SIGN_UP_ERROR_1)
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignUpDatabaseConstrainViolationException.class)
    public ResponseEntity<ResponseDTO<?>> handleSignUpException(SignUpDatabaseConstrainViolationException ex){
        ResponseDTO<?> response =  ResponseDTO.<User>responseBuilder()
                .statusCode(StatusCode.SIGN_UP_ERROR_2)
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignInErrorException.class)
    public ResponseEntity<ResponseDTO<?>> handleSignInException(SignInErrorException ex){
        ResponseDTO<?> response = ResponseDTO.<User>responseBuilder()
                .statusCode("402")
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidSignInDataException.class)
    public ResponseEntity<ResponseDTO<?>> handleInvalidSignInDataException(InvalidSignInDataException ex){
        ResponseDTO<?> response = ResponseDTO.<User>responseBuilder()
                .statusCode("403")
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingTokenException.class)
    public ResponseEntity<ResponseDTO<?>> handleMissingHeaderException(MissingTokenException ex){
        ResponseDTO<?> response = ResponseDTO.responseBuilder()
                .statusCode("404")
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChangePasswordErrorException.class)
    public ResponseEntity<ResponseDTO<?>> handleChangePasswordException(ChangePasswordErrorException ex){
        ResponseDTO<?> response = ResponseDTO.responseBuilder()
                .statusCode("405")
                .statusMessage(ex.getMessage())
                .data(null)
                .errors(ex.getErrors())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
