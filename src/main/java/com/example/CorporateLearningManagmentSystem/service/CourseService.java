package com.example.CorporateLearningManagmentSystem.service;

import com.example.CorporateLearningManagmentSystem.dto.ModuleDetails;
import com.example.CorporateLearningManagmentSystem.dto.ResourceDetails;
import com.example.CorporateLearningManagmentSystem.entity.CourseModuleResourceMapping;
import com.example.CorporateLearningManagmentSystem.entity.Module;
import com.example.CorporateLearningManagmentSystem.entity.Resource;
import com.example.CorporateLearningManagmentSystem.repository.CourseModuleResourceMappingRepository;
import com.example.CorporateLearningManagmentSystem.repository.CourseRepository;
import com.example.CorporateLearningManagmentSystem.dto.CourseDetails;
import com.example.CorporateLearningManagmentSystem.entity.Course;
import com.example.CorporateLearningManagmentSystem.repository.ModuleRepository;
import com.example.CorporateLearningManagmentSystem.repository.ResourceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private CourseModuleResourceMappingRepository courseModuleResourceMappingRepository;


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
        List<ModuleDetails> moduleDetailsList = null;
        if (course.getModules() != null && !course.getModules().isEmpty()) {
            moduleDetailsList = course.getModules().stream()
                    .map(module -> {
                        List<ResourceDetails> resourceDetailsList = module.getResources().stream()
                                .map(resource -> new ResourceDetails(
                                        resource.getResourceId(),
                                        resource.getFileType(),
                                        resource.getfilename()
                                ))
                                .collect(Collectors.toList());

                        return new ModuleDetails(module.getModuleId(), module.getModuleName(), resourceDetailsList);
                    })
                    .collect(Collectors.toList());


        }
        return new CourseDetails(
                course.getCourseId(),
                course.getName(),
                course.getDescription(),
                course.getDuration(),
                moduleDetailsList
        );
    }

    /*------------------------Post Operation--------------------*/
    public CourseDetails createCourseWithModulesAndResources(CourseDetails courseDetails) {
        Course course = convertDtoToEntity(courseDetails);
        course = courseRepository.save(course);

        List<ModuleDetails> moduleDetailsList = courseDetails.getModuleDetails();
        if (moduleDetailsList != null) {
            for (ModuleDetails moduleDetails : moduleDetailsList) {
                Module module = convertModuleDtoToEntity(moduleDetails);
                module.setCourse(course);
                module = moduleRepository.save(module);

                List<ResourceDetails> resourceDetailsList = moduleDetails.getResourceDetails();
                if (resourceDetailsList != null) {
                    for (ResourceDetails resourceDetails : resourceDetailsList) {
                        Resource resource = convertResourceDtoToEntity(resourceDetails);
                        resource.setModule(module);
                        resourceRepository.save(resource);

                        CourseModuleResourceMapping mapping = new CourseModuleResourceMapping();
                        mapping.setCourse(mapping.getCourse());
                        mapping.setModule(mapping.getModule());
                        mapping.setResource(mapping.getResource());
                        courseModuleResourceMappingRepository.save(mapping);
                    }
                }
            }
        }
        //return "Created done";
        return new CourseDetails(
                course.getCourseId(),
                course.getName(),
                course.getDescription(),
                course.getDuration(),
                moduleDetailsList
        );
    }

    private Course convertDtoToEntity(CourseDetails courseDetails) {
        return new Course(
                courseDetails.getName(),
                courseDetails.getDescription(),
                courseDetails.getDuration()
        );
    }

    private Module convertModuleDtoToEntity(ModuleDetails moduleDetails) {
        return new Module(
                moduleDetails.getModuleName()
        );
    }

    private Resource convertResourceDtoToEntity(ResourceDetails resourceDetails) {
        return new Resource(
                resourceDetails.getFileType(),
                resourceDetails.getfilename()
        );
    }

    public void deleteCourseById(int courseId) {
        Course course = courseRepository.findById(courseId).get();
        courseRepository.deleteById(courseId);
    }


    /*--------------------------update------------------------------*/

    public CourseDetails updateCourseWithModulesAndResources(int courseId, CourseDetails updatedCourseDetails) {
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));

        existingCourse.setName(updatedCourseDetails.getName());
        existingCourse.setDescription(updatedCourseDetails.getDescription());
        existingCourse.setDuration(updatedCourseDetails.getDuration());

        List<ModuleDetails> updatedModuleDetailsList = updatedCourseDetails.getModuleDetails();
        if (updatedModuleDetailsList != null) {
            for (ModuleDetails updatedModuleDetails : updatedModuleDetailsList) {
                Module existingModule = existingCourse.getModules().stream()
                        .filter(module -> module.getModuleId() == updatedModuleDetails.getModuleId())
                        .findFirst()
                        .orElseThrow(() -> new EntityNotFoundException("Module not found with id: " + updatedModuleDetails.getModuleId()));

                existingModule.setModuleName(updatedModuleDetails.getModuleName());

                List<ResourceDetails> updatedResourceDetailsList = updatedModuleDetails.getResourceDetails();
                if (updatedResourceDetailsList != null) {
                    for (ResourceDetails updatedResourceDetails : updatedResourceDetailsList) {
                        Resource existingResource = existingModule.getResources().stream()
                                .filter(resource -> resource.getResourceId() == updatedResourceDetails.getResourceId())
                                .findFirst()
                                .orElseThrow(() -> new EntityNotFoundException("Resource not found with id: " + updatedResourceDetails.getResourceId()));

                        // Update resource details
                        existingResource.setFileType(updatedResourceDetails.getFileType());
                        existingResource.setfilename(updatedResourceDetails.getfilename());
                    }
                }
            }
        }

        Course updatedCourse = courseRepository.save(existingCourse);

        return convertEntityToDtoWithModulesAndResources(updatedCourse);
    }
}

