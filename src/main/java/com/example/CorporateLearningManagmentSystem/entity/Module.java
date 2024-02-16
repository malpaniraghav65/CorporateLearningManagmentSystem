package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int moduleId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "module_name")
    private String moduleName;

    @OneToMany(mappedBy = "module")
    private List<CourseModuleResourceMapping> mappings;

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
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

    public Module(int moduleId, Course course, String moduleName, List<CourseModuleResourceMapping> mappings) {
        this.moduleId = moduleId;
        this.course = course;
        this.moduleName = moduleName;
        this.mappings = mappings;
    }

    public Module() {
    }
}
