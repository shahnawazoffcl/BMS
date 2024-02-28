package com.bms.auth.dto.UserDTO;


import com.bms.auth.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserLoginDTO {
    private String email;
    private Set<Role> roles;
}
