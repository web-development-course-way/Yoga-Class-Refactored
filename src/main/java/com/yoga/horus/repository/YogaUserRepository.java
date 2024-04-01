package com.yoga.horus.repository;

import com.yoga.horus.entity.YogaUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YogaUserRepository extends JpaRepository<YogaUser, UUID> {
}
