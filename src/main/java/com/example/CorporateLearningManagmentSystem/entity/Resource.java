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

    @Lob
    @Column(name = "actual_file")
    private byte[] actualFile;

    @OneToMany(mappedBy = "resource")
    private List<CourseModuleResourceMapping> mappings;

    public int getResourceId() {
        return resourceId;
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

    public byte[] getActualFile() {
        return actualFile;
    }

    public void setActualFile(byte[] actualFile) {
        this.actualFile = actualFile;
    }

    public List<CourseModuleResourceMapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<CourseModuleResourceMapping> mappings) {
        this.mappings = mappings;
    }

    public Resource(int resourceId, String fileType, byte[] actualFile, List<CourseModuleResourceMapping> mappings) {
        this.resourceId = resourceId;
        this.fileType = fileType;
        this.actualFile = actualFile;
        this.mappings = mappings;
    }

    public Resource() {
    }
}
