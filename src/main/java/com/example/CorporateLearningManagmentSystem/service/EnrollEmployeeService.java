package com.example.CorporateLearningManagmentSystem.service;

import com.example.CorporateLearningManagmentSystem.dto.enrolledEmployeedto;
import com.example.CorporateLearningManagmentSystem.repository.Enrolled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollEmployeeService {
@Autowired
 private  Enrolled enrolledRepository;

 public List<enrolledEmployeedto> getEnrolledEmployees() {
  List<com.example.CorporateLearningManagmentSystem.entity.Enrolled> enrolledList = enrolledRepository.findAll();
  return enrolledList.stream()
          .map(this::convertToDTO)
          .collect(Collectors.toList());
 }

 private enrolledEmployeedto convertToDTO(com.example.CorporateLearningManagmentSystem.entity.Enrolled enrolled) {
  return new enrolledEmployeedto(
          enrolled.getUser().getId(),
          enrolled.getCourse().getCourseId(),
          enrolled.getStatus(),
          enrolled.getStartdate(),
          enrolled.getEnddate()
  );
 }
}
