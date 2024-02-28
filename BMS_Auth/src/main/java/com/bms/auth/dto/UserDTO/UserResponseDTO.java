package com.bms.auth.dto.UserDTO;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class UserResponseDTO {
    private UUID id;
    private String name;
    private String password;
    private String email;

    public String toString(){
        return ", name='" + name + '\'' +
                ", email='" + email + '\'';
    }
}
