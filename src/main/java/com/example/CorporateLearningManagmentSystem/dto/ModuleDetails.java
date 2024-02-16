package com.example.CorporateLearningManagmentSystem.dto;

import com.example.CorporateLearningManagmentSystem.entity.Course;
import lombok.Data;


public class ModuleDetails {
    private Long moduleId;
    private Course course;
    private String moduleName;

    public ModuleDetails() {
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public ModuleDetails(Long moduleId, Course course, String moduleName) {
        this.moduleId = moduleId;
        this.course = course;
        this.moduleName = moduleName;
    }
}
