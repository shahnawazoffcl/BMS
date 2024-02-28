package com.bms.auth.controllers.utils;

import com.bms.auth.dto.UserDTO.UserLoginDTO;
import com.bms.auth.dto.UserDTO.UserSignUpDTO;
import com.bms.auth.dto.UserDTO.UserResponseDTO;
import com.bms.auth.models.User;

public class UserControllerUtils {
    public static UserResponseDTO convertUserToUseResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPassword(user.getPassword());
        return userResponseDTO;
    }

    public static User convertUserRequestDTOtoUser(UserSignUpDTO userRequestDTO){
        User user = new User();
        user.setEmail(userRequestDTO.getEmail());
//        user.setName(userRequestDTO.getName());
        user.setPassword(userRequestDTO.getPassword());
        return user;
    }

    public static UserLoginDTO convertSessionToUserLoginDTO(User user) {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setEmail(user.getEmail());
        userLoginDTO.setRoles(user.getRoles());
        return userLoginDTO;

    }

    public static UserSignUpDTO convertUserToUserSignUpDTO(User user) {
        UserSignUpDTO userSignUpDTO = new UserSignUpDTO();
        userSignUpDTO.setEmail(user.getEmail());
//        userSignUpDTO.setName(user.getName());
        userSignUpDTO.setPassword(user.getPassword());
        return userSignUpDTO;
    }
}
