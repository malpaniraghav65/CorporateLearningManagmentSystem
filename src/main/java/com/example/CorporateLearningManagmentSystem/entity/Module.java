package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long moduleId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "module_name")
    private String moduleName;

    @OneToMany(mappedBy = "module")
    private List<CourseModuleResourceMapping> mappings;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    private List<Resource> resources;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<CourseModuleResourceMapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<CourseModuleResourceMapping> mappings) {
        this.mappings = mappings;
    }

    public Module(Long moduleId, Course course, String moduleName, List<CourseModuleResourceMapping> mappings, List<Resource> resources) {
        this.moduleId = moduleId;
        this.course = course;
        this.moduleName = moduleName;
        this.mappings = mappings;
        this.resources = resources;
    }

    public Module() {
    }
}
