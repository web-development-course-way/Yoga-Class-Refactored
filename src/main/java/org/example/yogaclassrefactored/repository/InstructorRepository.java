package org.example.yogaclassrefactored.repository;

import org.example.yogaclassrefactored.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> { }
