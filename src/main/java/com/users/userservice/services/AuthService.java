package com.users.userservice.services;

import com.users.userservice.dtos.LoginRequestDto;
import com.users.userservice.dtos.UserDto;
import com.users.userservice.exception.InvalidCredentialExceptions;
import com.users.userservice.exception.UserNotFoundException;
import com.users.userservice.model.User;
import com.users.userservice.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.MacAlgorithm;


import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.*;

@Service
public class AuthService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<UserDto> login(LoginRequestDto loginRequestDto) throws UserNotFoundException, InvalidCredentialExceptions {
        //getting UserDetails from db
        Optional<User> userOptional=userRepository.findByEmail(loginRequestDto.getEmail());
        if(userOptional.isEmpty()){

            throw new UserNotFoundException("Invalid Login Credentials");
        }
        User user =  userOptional.get();
        //verify if password is correct or not
        if(!bCryptPasswordEncoder.matches(loginRequestDto.getPassword(), user.getPassword()))
        {
            throw new InvalidCredentialExceptions("Invalid Password");
        }
        //token generation

       // String token=RandomStringUtils.randomAlphanumeric(30);
        MacAlgorithm  algorithm= Jwts.SIG.HS256;//HS256 algo for JWT
        SecretKey key = algorithm.key().build(); //generating the secret key

        //start adding the claims
        Map<String,Object> jsonForJWT =new HashMap<>();
        jsonForJWT.put("userId",user.getId());
        jsonForJWT.put("roles",user.getRoles());
        jsonForJWT.put("createdAt",new Date());
        jsonForJWT.put("expiryAt",new Date(LocalDate.now().plusDays(3).toEpochDay()));





        UserDto userDto=null;

        return new ResponseEntity<>(userDto, HttpStatus.OK);

    }

    public UserDto signUp(){


        return new UserDto();
    }
}
