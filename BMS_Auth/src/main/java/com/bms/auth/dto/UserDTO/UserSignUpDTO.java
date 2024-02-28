package com.bms.auth.dto.UserDTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignUpDTO {
    private String password;
    private String email;
}
