package com.yoga.horus.repository;

import com.yoga.horus.entity.YogaClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface YogaClassRepository extends JpaRepository<YogaClass, UUID> {

}
