package com.example.CorporateLearningManagmentSystem.Repository;

import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}