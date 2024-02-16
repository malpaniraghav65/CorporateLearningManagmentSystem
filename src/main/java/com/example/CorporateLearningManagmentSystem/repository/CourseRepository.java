package com.example.CorporateLearningManagmentSystem.repository;

import com.example.CorporateLearningManagmentSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
