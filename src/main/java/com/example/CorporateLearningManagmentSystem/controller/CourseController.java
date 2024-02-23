package com.example.CorporateLearningManagmentSystem.controller;

import com.example.CorporateLearningManagmentSystem.dto.CourseDetails;
import com.example.CorporateLearningManagmentSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

     private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/Details")
    public List<CourseDetails> getAllCourseService(){
        return courseService.getAllCourseService();
    }
}
