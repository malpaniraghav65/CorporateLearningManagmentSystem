package com.example.CorporateLearningManagmentSystem.helper;

import com.example.CorporateLearningManagmentSystem.dto.ResourceDetails;
import com.example.CorporateLearningManagmentSystem.entity.Resource;
import com.example.CorporateLearningManagmentSystem.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

            // Get the original file name
            String originalFileName = multipartFile.getOriginalFilename();

            // Create a new file name with timestamp appended
            String fileNameWithTimestamp = originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                    + "_" + timeStamp
                    + originalFileName.substring(originalFileName.lastIndexOf('.'));

            // Set the file name in ResourceDetails
            ResourceDetails resourceDetails = new ResourceDetails();
            resourceDetails.setFileType(fileNameWithTimestamp);

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
        resource.setFileType(resourceDetails.getFileType());
        resourceRepository.save(resource);
    }
}
