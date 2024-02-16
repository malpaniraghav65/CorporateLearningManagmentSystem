package com.example.CorporateLearningManagmentSystem;

import com.example.CorporateLearningManagmentSystem.dto.CourseDetails;
import com.example.CorporateLearningManagmentSystem.entity.Course;
import com.example.CorporateLearningManagmentSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorporateLearningManagmentSystemApplication{

	public static void main(String[] args) {
		SpringApplication.run(CorporateLearningManagmentSystemApplication.class, args);
	}

}
