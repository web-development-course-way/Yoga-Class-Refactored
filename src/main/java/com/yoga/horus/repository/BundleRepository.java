package com.yoga.horus.repository;

import com.yoga.horus.entity.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BundleRepository extends JpaRepository<Bundle,UUID> {
}
