package com.yoga.horus.repository;

import com.yoga.horus.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {
}
