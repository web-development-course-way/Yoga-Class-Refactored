package org.example.yogaclassrefactored.repository;

import org.example.yogaclassrefactored.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
