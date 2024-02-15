package com.example.CorporateLearningManagmentSystem.dto;

import com.example.CorporateLearningManagmentSystem.entity.Course;
import lombok.Data;

@Data
public class ModuleDetails {
    private Long moduleId;
    private Course course;
    private String moduleName;

    public ModuleDetails(Long moduleId, Course course, String moduleName) {
        this.moduleId = moduleId;
        this.course = course;
        this.moduleName = moduleName;
    }
}
