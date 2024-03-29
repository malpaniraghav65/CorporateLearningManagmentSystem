package com.example.CorporateLearningManagmentSystem.repository;

import com.example.CorporateLearningManagmentSystem.entity.CourseModuleResourceMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseModuleResourceMappingRepository extends JpaRepository<CourseModuleResourceMapping, Integer> {
}
