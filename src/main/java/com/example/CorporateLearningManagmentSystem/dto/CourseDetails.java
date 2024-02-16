package com.example.CorporateLearningManagmentSystem.dto;

import com.example.CorporateLearningManagmentSystem.entity.CourseModuleResourceMapping;
import lombok.Data;

import java.util.List;


public class CourseDetails {
    private Long courseId;
    private String name;
    private String description;
    private int duration;

    private List<ModuleDetails> moduleDetails;

    public CourseDetails(Long courseId, String name, String description, int duration) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public List<ModuleDetails> getModuleDetails() {
        return moduleDetails;
    }

    public void setModuleDetails(List<ModuleDetails> moduleDetails) {
        this.moduleDetails = moduleDetails;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseDetails(Long courseId, String name, String description, int duration, List<ModuleDetails> moduleDetails) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.moduleDetails = moduleDetails;
    }

    public CourseDetails() {

    }
}
