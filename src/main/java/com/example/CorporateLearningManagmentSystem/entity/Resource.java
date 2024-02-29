package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int resourceId;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_name")
    private String filename;

    @OneToMany(mappedBy = "resource")
    private List<CourseModuleResourceMapping> mappings;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public Resource(String fileType, String filename) {
        this.fileType=fileType;
        this.filename=filename;
    }

    public Resource(String fileNameWithTimestamp) {
        this.fileType=fileNameWithTimestamp;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

   
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getfilename() {
        return filename;
    }

    public void setfilename(String filename) {
        this.filename = filename;
    }

    public List<CourseModuleResourceMapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<CourseModuleResourceMapping> mappings) {
        this.mappings = mappings;
    }

    public Resource(int resourceId, String fileType, String filename, List<CourseModuleResourceMapping> mappings) {
        this.resourceId = resourceId;
        this.fileType = fileType;
        this.filename = filename;
        this.mappings = mappings;
    }

    public Resource() {
    }
        public int getResourceId() {
            return resourceId;
        }
    }
