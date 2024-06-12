package com.users.userservice.controlleradvice;

import com.users.userservice.dtos.ErrorResponseDto;
import com.users.userservice.exception.InvalidCredentialExceptions;
import com.users.userservice.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = InvalidCredentialExceptions.class)
    public ResponseEntity<ErrorResponseDto>  handleInvalidCredentialsException(InvalidCredentialExceptions ex){
        ErrorResponseDto apiResponse= new ErrorResponseDto();
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setCode(404);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto>  handleUserNotFoundException(UserNotFoundException ex){
        ErrorResponseDto apiResponse= new ErrorResponseDto();
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setCode(404);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
