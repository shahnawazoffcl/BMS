package com.bms.auth.controllers;

import com.bms.auth.controllers.utils.UserControllerUtils;
import com.bms.auth.dto.UserDTO.UserResponseDTO;
import com.bms.auth.models.User;
import com.bms.auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserDetails(@PathVariable("id") UUID id){
        User user = userService.getUserById(id);
        UserResponseDTO userResponseDTO = UserControllerUtils.convertUserToUseResponseDTO(user);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<UserResponseDTO> setUserRoles(@PathVariable("id") UUID id, @RequestBody List<UUID> roleIds){
        User user = userService.setUserRoles(id, roleIds);
        UserResponseDTO userResponseDTO = UserControllerUtils.convertUserToUseResponseDTO(user);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }
}
