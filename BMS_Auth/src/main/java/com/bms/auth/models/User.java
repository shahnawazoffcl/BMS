package com.bms.auth.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class User extends BaseModel{
    private String name;
    private String password;
    private String email;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
