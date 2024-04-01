package com.yoga.horus.repository;

import com.yoga.horus.entity.YogaClassInstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YogaClassInstructorRepository extends JpaRepository<YogaClassInstructor, UUID> {
}
