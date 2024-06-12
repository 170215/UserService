package com.users.userservice.Controller;

import com.users.userservice.services.UserService;
import jakarta.persistence.Access;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //public ResponseEntity<>
}
