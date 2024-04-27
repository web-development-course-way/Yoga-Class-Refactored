package com.horus.yoga.repository;

import com.horus.yoga.entity.YogaClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface YogaClassRepository extends JpaRepository<YogaClass, UUID> {

}
