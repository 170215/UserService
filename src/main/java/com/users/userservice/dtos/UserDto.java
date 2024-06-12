package com.users.userservice.dtos;


import com.users.userservice.model.Role;
import com.users.userservice.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
public class UserDto
{
    private String email;
    private Set<Role> roles=new HashSet<>();

    public static UserDto from(User user){
        UserDto userDto=new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }

}
