package com.example.CorporateLearningManagmentSystem.controller;

import com.example.CorporateLearningManagmentSystem.dto.CourseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseController courseController;

    @GetMapping("/courseDetails")
    public List<CourseDetails> getAllCourseDetails(){
        return courseController.getAllCourseDetails();
    }
}
