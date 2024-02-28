package com.bms.auth.service;


import com.bms.auth.models.Session;
import com.bms.auth.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User addUser(User user);

    User getUserByEmailAndPassword(String email, String password);

    User getUserById(UUID id);

    User setUserRoles(UUID userId, List<UUID> roleIds);

    List<Session> getAllSessions();
}
