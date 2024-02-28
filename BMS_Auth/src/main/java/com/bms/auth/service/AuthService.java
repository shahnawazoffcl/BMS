package com.bms.auth.service;

import com.bms.auth.models.Session;
import com.bms.auth.models.User;

import java.util.List;
import java.util.UUID;

public interface AuthService {
    Session login(String email, String password);
    User signup(String email, String password);

    void logout(String token, UUID userId);

    List<Session> getAllSessions();
}
