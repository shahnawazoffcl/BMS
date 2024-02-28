package com.bms.auth.service.impl;

import com.bms.auth.exceptions.UserNotFoundException;
import com.bms.auth.models.Session;
import com.bms.auth.models.SessionStatus;
import com.bms.auth.models.User;
import com.bms.auth.repository.SessionRepository;
import com.bms.auth.repository.UserRepository;
import com.bms.auth.service.AuthService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public AuthServiceImpl(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Session login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found with email: " + email);
        }

        if(!user.get().getPassword().equals(password)){
            throw new UserNotFoundException("Invalid password");
        }

        String token = RandomStringUtils.randomAlphanumeric(20);

        Session session = new Session();
        session.setToken(token);
        session.setSessionStatus(SessionStatus.ACTIVE);
        session.setUser(user.get());
        session = sessionRepository.save(session);

        return session;
    }

    @Override
    public User signup(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new UserNotFoundException("User already exists with email: " + email);
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser = userRepository.save(newUser);

        return newUser;
    }

    @Override
    public void logout(String token, UUID userId) {
        Optional<Session> session = sessionRepository.findByTokenAndUser_Id(token, userId);
        if(session.isEmpty()){
            throw new UserNotFoundException("Session not found with token: " + token);
        }

        session.get().setSessionStatus(SessionStatus.ENDED);
        sessionRepository.save(session.get());
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }


}
