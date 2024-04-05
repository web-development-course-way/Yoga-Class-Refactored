package com.yoga.horus.repository;

import com.yoga.horus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);

}
