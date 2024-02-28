package com.bms.auth.dto.sessionDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SessionDTO {
    private String token;
    private UUID userId;
}
