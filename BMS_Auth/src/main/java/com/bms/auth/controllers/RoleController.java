package com.bms.auth.controllers;

import com.bms.auth.dto.RoleRequestDTO;
import com.bms.auth.dto.RoleResponseDTO;
import com.bms.auth.models.Role;
import com.bms.auth.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/role")
@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/")
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        Role role = roleService.createRole(roleRequestDTO.getRoleName());
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setRoleName(role.getRoleName());
        return new ResponseEntity<>(roleResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Role>> getRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }

}
