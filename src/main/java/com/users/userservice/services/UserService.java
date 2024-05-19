package com.users.userservice.services;

import com.users.userservice.dtos.UserDto;
import com.users.userservice.model.Role;
import com.users.userservice.model.User;
import com.users.userservice.repository.RoleRepository;
import com.users.userservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public UserDto getUserDetails(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            return null;
        }
        return UserDto.from(userOptional.get());
    }


    public UserDto setUserRoles(Long userId, List<Long> roleIds){
        Optional<User> userOptional = userRepository.findById(userId);
        Set<Role> roles=roleRepository.findAllByIdIn(roleIds);
        if (userOptional.isEmpty()){return null;}
        User user = userOptional.get();
        user.setRoles(roles);
        User savedUser = userRepository.save(user);
        userOptional.get().setRoles(roles);
        return UserDto.from(savedUser);
    }


}
