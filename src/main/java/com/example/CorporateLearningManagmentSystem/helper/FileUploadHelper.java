package com.example.CorporateLearningManagmentSystem.helper;

import com.example.CorporateLearningManagmentSystem.dto.ResourceDetails;
import com.example.CorporateLearningManagmentSystem.entity.Module;
import com.example.CorporateLearningManagmentSystem.entity.Resource;
import com.example.CorporateLearningManagmentSystem.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileUploadHelper {
    @Autowired
    private ResourceRepository resourceRepository;
    public final String UPLOAD_DIR = "/home/azilen/Downloads/CorporateLearningManagmentSystem/src/main/resources/static/Resources";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean f=false;

        try {

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String originalFileName = multipartFile.getOriginalFilename();

            String fileNameWithTimestamp = originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                    + "_" + timeStamp
                    + originalFileName.substring(originalFileName.lastIndexOf('.'));

            // Set the file name in ResourceDetails
            ResourceDetails resourceDetails = new ResourceDetails();
            resourceDetails.setfilename(fileNameWithTimestamp);
            resourceDetails.setFileType(fileNameWithTimestamp.substring(fileNameWithTimestamp.lastIndexOf(".")+1));

            // Save file to the server
            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + File.separator + fileNameWithTimestamp);
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

            saveResourceToDatabase(resourceDetails);

            f = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    private void saveResourceToDatabase(ResourceDetails resourceDetails) {
        Resource resource = new Resource();
        resource.setfilename(resourceDetails.getfilename());
        resource.setFileType(resourceDetails.getFileType());
        resourceRepository.save(resource);
    }

    public boolean associateModuleWithResource(int resourceId, Module moduleId) {
        try {
            Resource resource = resourceRepository.findById(resourceId).orElse(null);
            if (resource != null) {
                resource.setModule(moduleId);
                resourceRepository.save(resource);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*------------------------------- update resources-----------------------------------*/
    public boolean updateResource(int resourceId, MultipartFile updatedFile) {
        try {
            Resource existingResource = resourceRepository.findById(resourceId).orElse(null);
            if (existingResource != null) {
                // Save the updated file and details to the server
                saveFileAndDetails(updatedFile, existingResource);

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void saveFileAndDetails(MultipartFile file, Resource existingResource) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String originalFileName = file.getOriginalFilename();
        String fileNameWithTimestamp = originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                + "_" + timeStamp
                + originalFileName.substring(originalFileName.lastIndexOf('.'));

        // Save the updated file to the server
        FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + File.separator + fileNameWithTimestamp);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();

        // Update resource details in the database
        existingResource.setfilename(fileNameWithTimestamp);
        existingResource.setFileType(fileNameWithTimestamp.substring(fileNameWithTimestamp.lastIndexOf('.') + 1));
        resourceRepository.save(existingResource);
    }

    /*------------------------------- delete resources-----------------------------------*/

    public boolean deleteResource(int resourceId) {
        try {
            Resource resourceToDelete = resourceRepository.findById(resourceId).orElse(null);
            if (resourceToDelete != null) {
                // Delete the file from the server
                deleteFile(resourceToDelete.getfilename());

                // Delete the resource from the database
                resourceRepository.delete(resourceToDelete);

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void deleteFile(String filename) {
        File fileToDelete = new File(UPLOAD_DIR + File.separator + filename);
        if (fileToDelete.exists()) {
            fileToDelete.delete();
        }
    }
}
