package com.example.CorporateLearningManagmentSystem.dto;

import lombok.Data;
@Data
public class CourseDetails {
    private Long courseId;
    private String name;
    private String description;
    private int duration;

    public CourseDetails(Long courseId, String name, String description, int duration) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public CourseDetails() {

    }
}
