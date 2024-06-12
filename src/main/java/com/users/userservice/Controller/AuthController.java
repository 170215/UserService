package com.users.userservice.Controller;

import com.users.userservice.dtos.LoginRequestDto;
import com.users.userservice.dtos.UserDto;
import com.users.userservice.exception.InvalidCredentialExceptions;
import com.users.userservice.exception.UserNotFoundException;
import com.users.userservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public ResponseEntity<UserDto> login(LoginRequestDto loginRequestDto) throws UserNotFoundException, InvalidCredentialExceptions {
       return authService.login(loginRequestDto);
    }
}
