package com.example.CorporateLearningManagmentSystem.repository;

import com.example.CorporateLearningManagmentSystem.entity.ReportingmanagerEmployeeMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportingmanagerEmployee extends JpaRepository<ReportingmanagerEmployeeMapping,Long> {
}
