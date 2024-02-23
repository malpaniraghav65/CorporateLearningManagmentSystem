package com.example.CorporateLearningManagmentSystem.service;

import com.example.CorporateLearningManagmentSystem.repository.CourseRepository;
import com.example.CorporateLearningManagmentSystem.dto.CourseDetails;
import com.example.CorporateLearningManagmentSystem.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

        public List<CourseDetails> getAllCourseService(){
            List<CourseDetails> result = courseRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
            return result;
        }

        private CourseDetails convertEntityToDto(Course course){
            return new CourseDetails(
                  course.getCourseId(),
                    course.getName(),
                    course.getDescription(),
                    course.getDuration()
            );
        }
}
