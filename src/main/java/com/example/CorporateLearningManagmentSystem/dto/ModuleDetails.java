package com.example.CorporateLearningManagmentSystem.dto;

import com.example.CorporateLearningManagmentSystem.entity.Course;
import lombok.Data;

import java.util.List;


public class ModuleDetails {
    private int moduleId;
    //private Course course;
    private String moduleName;


    private List<ResourceDetails> resourceDetails;

    public List<ResourceDetails> getResourceDetails() {
        return resourceDetails;
    }

    public void setResourceDetails(List<ResourceDetails> resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

    public ModuleDetails() {
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public ModuleDetails(int moduleId, String moduleName, List<ResourceDetails> resourceDetails) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.resourceDetails = resourceDetails;
    }


    public ModuleDetails(int moduleId, String moduleName) {
        this.moduleId = moduleId;
//        this.course = course;
        this.moduleName = moduleName;
    }
}
