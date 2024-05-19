package com.users.userservice.services;

import com.users.userservice.model.Role;
import com.users.userservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(String name) {
        Role role =new Role();
        role.setRole(name);
        return roleRepository.save(role);
    }
}
