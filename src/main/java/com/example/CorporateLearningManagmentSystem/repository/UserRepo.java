package com.example.CorporateLearningManagmentSystem.repository;

import com.example.CorporateLearningManagmentSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
