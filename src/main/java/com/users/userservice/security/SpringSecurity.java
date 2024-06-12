package com.users.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SpringSecurity {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
      return new BCryptPasswordEncoder();
    }
}
