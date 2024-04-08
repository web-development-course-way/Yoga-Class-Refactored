package com.horus.yoga.repository;

import com.horus.yoga.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional <User> findByEmail(String email);
}
