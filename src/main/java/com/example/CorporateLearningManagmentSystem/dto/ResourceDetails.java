package com.example.CorporateLearningManagmentSystem.dto;

import lombok.Data;


public class ResourceDetails {
    private Long resourceId;
    private String fileType;
    private byte[] actualFile;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
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

    public ResourceDetails() {
    }

    public ResourceDetails(Long resourceId, String fileType, byte[] actualFile) {
        this.resourceId = resourceId;
        this.fileType = fileType;
        this.actualFile = actualFile;
    }
}
