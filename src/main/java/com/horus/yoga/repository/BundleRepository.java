package com.horus.yoga.repository;

import com.horus.yoga.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BundleRepository extends JpaRepository<Bundle,UUID> {
}
