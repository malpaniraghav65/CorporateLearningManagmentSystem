package com.example.CorporateLearningManagmentSystem.controller;

import com.example.CorporateLearningManagmentSystem.entity.Module;
import com.example.CorporateLearningManagmentSystem.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file) {

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file.");
            }
            boolean f = fileUploadService.uploadFile(file);
            if(f){
                return ResponseEntity.ok("File is successfully uploaded");
            }
        }catch (Exception e){
            e.printStackTrace();

        }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again");
    }

    @PostMapping("/associate-module")
    public ResponseEntity<String> associateModuleWithResource(
            @RequestParam("resourceId") int resourceId,
            @RequestParam("moduleId") Module moduleId) {
        try {
            boolean success = fileUploadService.associateModuleWithResource(resourceId, moduleId);
            if (success) {
                return ResponseEntity.ok("Module associated successfully with ResourceId: " + resourceId);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again");
    }

    @PutMapping("/update-resource/{resourceId}")
    public ResponseEntity<String> updateResource(@PathVariable("resourceId") int resourceId, @RequestParam("file") MultipartFile updatedFile) {
        try {
            boolean success = fileUploadService.updateResource(resourceId, updatedFile);

            if (success) {
                return ResponseEntity.ok("Resource updated successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again");
        }
    }

    @DeleteMapping("/delete-resource")
    public ResponseEntity<String> deleteResource(@RequestParam("resourceId") int resourceId) {
        try {
            boolean success = fileUploadService.deleteResource(resourceId);

            if (success) {
                return ResponseEntity.ok("Resource deleted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again");
        }
    }
}
