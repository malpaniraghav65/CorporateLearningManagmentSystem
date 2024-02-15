package com.example.CorporateLearningManagmentSystem.service;

import com.example.CorporateLearningManagmentSystem.Repository.CourseRepository;
import com.example.CorporateLearningManagmentSystem.dto.CourseDetails;
import com.example.CorporateLearningManagmentSystem.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
        @Autowired
        private CourseRepository courseRepository;

        public List<CourseDetails> getAllCourseService(){
            return courseRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
        }

        private CourseDetails convertEntityToDto(Course course){
            CourseDetails courseDetails = new CourseDetails();
            courseDetails.setCourseId(course.getCourseId());
            courseDetails.setName(course.getName());
            courseDetails.setDescription(courseDetails.getDescription());
            courseDetails.setDuration(courseDetails.getDuration());
            return courseDetails;
        }

}
