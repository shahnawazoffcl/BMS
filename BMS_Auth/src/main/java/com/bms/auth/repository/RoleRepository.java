package com.bms.auth.repository;

import com.bms.auth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    Set<Role> findAllByIdIn(List<UUID> ids);
}