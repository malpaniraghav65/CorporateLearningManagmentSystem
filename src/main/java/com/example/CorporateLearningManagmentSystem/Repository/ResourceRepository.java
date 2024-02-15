package com.example.CorporateLearningManagmentSystem.Repository;

import com.example.CorporateLearningManagmentSystem.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
