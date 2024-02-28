package com.bms.auth.service.impl;

import com.bms.auth.models.Role;
import com.bms.auth.repository.RoleRepository;
import com.bms.auth.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String name) {
        Role role = new Role();
        role.setRoleName(name);
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
