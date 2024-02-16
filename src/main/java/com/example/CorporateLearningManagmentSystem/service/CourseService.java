package com.example.CorporateLearningManagmentSystem.service;

import com.example.CorporateLearningManagmentSystem.dto.ModuleDetails;
import com.example.CorporateLearningManagmentSystem.dto.ResourceDetails;
import com.example.CorporateLearningManagmentSystem.repository.CourseRepository;
import com.example.CorporateLearningManagmentSystem.dto.CourseDetails;
import com.example.CorporateLearningManagmentSystem.entity.Course;
import com.example.CorporateLearningManagmentSystem.repository.ModuleRepository;
import com.example.CorporateLearningManagmentSystem.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private ModuleRepository moduleRepository;
    private ResourceRepository resourceRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, ModuleRepository moduleRepository, ResourceRepository resourceRepository) {
        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
        this.resourceRepository = resourceRepository;
    }

        public List<CourseDetails> getAllCourseService(){
            List<CourseDetails> result = courseRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
            return result;
        }

        public List<CourseDetails> getAllCourseServiceWithModules() {
        List<CourseDetails> result = courseRepository.findAll().stream()
                .map(this::convertEntityToDtoWithModules)
                .collect(Collectors.toList());
        return result;
        }

        public List<CourseDetails> getAllCourseServiceWithModulesAndResources() {
        List<CourseDetails> result = courseRepository.findAll().stream()
                .map(this::convertEntityToDtoWithModulesAndResources)
                .collect(Collectors.toList());
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

    private CourseDetails convertEntityToDtoWithModules(Course course) {
        List<ModuleDetails> moduleDetailsList = course.getModules().stream().map(module -> new ModuleDetails(module.getModuleId(), module.getModuleName())).collect(Collectors.toList());


        return new CourseDetails(
                course.getCourseId(),
                course.getName(),
                course.getDescription(),
                course.getDuration(),
                moduleDetailsList
        );
    }

    private CourseDetails convertEntityToDtoWithModulesAndResources(Course course) {
        List<ModuleDetails> moduleDetailsList = course.getModules().stream()
                .map(module -> {List<ResourceDetails> resourceDetailsList = module.getResources().stream()
                            .map(resource -> new ResourceDetails(
                                    resource.getResourceId(),
                                    resource.getFileType(),
                                    resource.getActualFile()
                            ))
                            .collect(Collectors.toList());

                    return new ModuleDetails(module.getModuleId(), module.getModuleName(), resourceDetailsList);
                })
                .collect(Collectors.toList());

        return new CourseDetails(
                course.getCourseId(),
                course.getName(),
                course.getDescription(),
                course.getDuration(),
                moduleDetailsList
        );
    }
}
