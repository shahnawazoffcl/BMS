package com.bms.auth.repository;

import com.bms.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmailAndPassword(String email, String Password);
    Optional<User> findByEmail(String email);
}
