package com.users.userservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.util.HashSet;

@Entity(name = "ECOM_USER")
@Getter
@Setter
public class User extends BaseModel
{
    private String email;
    private String password;

    @ManyToMany
    private Set<Role> roles=new HashSet<>();
}
