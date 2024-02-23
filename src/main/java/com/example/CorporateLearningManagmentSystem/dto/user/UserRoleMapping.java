package com.example.CorporateLearningManagmentSystem.dto.user;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class UserRoleMapping {

    private int userId;

    private int rid;

}
