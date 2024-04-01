package com.yoga.horus.repository;

import com.yoga.horus.entity.YogaPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YogaPackageRepository extends JpaRepository<YogaPackage,UUID> {
}
