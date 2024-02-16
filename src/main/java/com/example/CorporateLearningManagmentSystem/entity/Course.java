package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Course")
public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long courseId;

        @Column(name = "name")
        private String name;

        @Column(name = "description")
        private String description;

        @Column(name = "duration")
        private int duration;

        @OneToMany(mappedBy = "course")
        private List<CourseModuleResourceMapping> mappings;

        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
        private List<Module> modules;

        public List<Module> getModules() {
                return modules;
        }

        public void setModules(List<Module> modules) {
                this.modules = modules;
        }

        public Long getCourseId() {
                return courseId;
        }

        public void setCourseId(Long courseId) {
                this.courseId = courseId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public int getDuration() {
                return duration;
        }

        public void setDuration(int duration) {
                this.duration = duration;
        }

        public List<CourseModuleResourceMapping> getMappings() {
                return mappings;
        }

        public void setMappings(List<CourseModuleResourceMapping> mappings) {
                this.mappings = mappings;
        }

        public Course(Long courseId, String name, String description, int duration, List<CourseModuleResourceMapping> mappings, List<Module> modules) {
                this.courseId = courseId;
                this.name = name;
                this.description = description;
                this.duration = duration;
                this.mappings = mappings;
                this.modules = modules;
        }

        public Course() {
        }
}
