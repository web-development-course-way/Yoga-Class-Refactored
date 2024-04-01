package com.yoga.horus.repository;

import com.yoga.horus.entity.YogaPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YogaPaymentRepository extends JpaRepository<YogaPayment, UUID> {
}
