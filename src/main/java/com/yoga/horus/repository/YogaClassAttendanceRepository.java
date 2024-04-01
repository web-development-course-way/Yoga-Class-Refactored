package com.yoga.horus.repository;

import com.yoga.horus.entity.YogaClassAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YogaClassAttendanceRepository extends JpaRepository<YogaClassAttendance, UUID> {
}
