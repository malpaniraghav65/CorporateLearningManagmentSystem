package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CourseModuleResourceMapping")
public class CourseModuleResourceMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapping_id")
    private Long mappingId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}