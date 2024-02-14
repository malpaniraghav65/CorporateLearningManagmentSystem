package com.example.CorporateLearningManagmentSystem.Repository;

import com.example.CorporateLearningManagmentSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
