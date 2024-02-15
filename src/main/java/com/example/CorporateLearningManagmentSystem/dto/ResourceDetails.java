package com.example.CorporateLearningManagmentSystem.dto;

import lombok.Data;

@Data
public class ResourceDetails {
    private Long resourceId;
    private String fileType;
    private byte[] actualFile;

    public ResourceDetails(Long resourceId, String fileType, byte[] actualFile) {
        this.resourceId = resourceId;
        this.fileType = fileType;
        this.actualFile = actualFile;
    }
}
