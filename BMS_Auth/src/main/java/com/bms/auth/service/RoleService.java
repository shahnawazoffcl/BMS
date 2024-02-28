package com.bms.auth.service;

import com.bms.auth.models.Role;

import java.util.List;

public interface RoleService {
    Role createRole(String name);

    List<Role> getRoles();
}
