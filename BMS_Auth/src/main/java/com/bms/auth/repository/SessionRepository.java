package com.bms.auth.repository;

import com.bms.auth.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<Session, UUID> {
    Optional<Session> findByTokenAndUser_Id(String token, UUID userId);

    Optional<Session> findByToken(String token);
}