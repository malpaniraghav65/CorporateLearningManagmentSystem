package com.example.CorporateLearningManagmentSystem.controller;

import com.example.CorporateLearningManagmentSystem.dto.CourseDetails;
import com.example.CorporateLearningManagmentSystem.dto.ModuleDetails;
import com.example.CorporateLearningManagmentSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
     private CourseService courseService;

    @GetMapping("/Details")
    public List<CourseDetails> getAllCourseService(){
        return courseService.getAllCourseService();
    }
    @GetMapping("/DetailsWithModules")
    public List<CourseDetails> getAllCourseServiceWithModules() {
        return courseService.getAllCourseServiceWithModules();  // Implement this method in CourseService
    }

    @GetMapping("/DetailsWithResources")
    public List<CourseDetails> convertEntityToDtoWithModulesAndResources(){
        return courseService.getAllCourseServiceWithModulesAndResources();
    }

    @PostMapping("/create")
    public ResponseEntity<CourseDetails> createCourseWithModulesAndResources(@RequestBody CourseDetails courseDetails) {
        CourseDetails createdCourse = courseService.createCourseWithModulesAndResources(courseDetails);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
            courseService.deleteCourseById(courseId);
            return "Course deleted successfully";
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }
        String fileName = file.getOriginalFilename();
        return ResponseEntity.ok("File uploaded successfully: " + fileName);
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<CourseDetails> updateCourseWithModulesAndResources(@PathVariable int courseId, @RequestBody CourseDetails updatedCourseDetails) {
        CourseDetails result = courseService.updateCourseWithModulesAndResources(courseId, updatedCourseDetails);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
