package com.example.CorporateLearningManagmentSystem.repository;

import com.example.CorporateLearningManagmentSystem.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
}
