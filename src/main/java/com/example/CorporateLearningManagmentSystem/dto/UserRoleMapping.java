package com.example.CorporateLearningManagmentSystem.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class UserRoleMapping {

    private int userId;

    private int rid;

}
