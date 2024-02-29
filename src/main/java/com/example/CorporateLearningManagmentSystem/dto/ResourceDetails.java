package com.example.CorporateLearningManagmentSystem.dto;

import lombok.Data;


public class ResourceDetails {
    private int resourceId;
    private String fileType;
    private String filename;


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

    public String getfilename() {
        return filename;
    }

    public void setfilename(String filename) {
        this.filename = filename;
    }

    public ResourceDetails() {
    }

    public ResourceDetails(int resourceId, String fileType, String filename) {
        this.resourceId = resourceId;
        this.fileType = fileType;
        this.filename = filename;
    }
}
