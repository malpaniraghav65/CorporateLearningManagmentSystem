package com.example.CorporateLearningManagmentSystem.controller;

import com.example.CorporateLearningManagmentSystem.dto.enrolledEmployeedto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CorporateLearningManagmentSystem.service.EnrollEmployeeService;

import java.util.List;

@RestController
@RequestMapping("/enrolldata")
public class enrolldata {
@Autowired
    private  EnrollEmployeeService enrollService;

    @GetMapping
    public List<enrolledEmployeedto> getEnrolledEmployees(){
        return enrollService.getEnrolledEmployees();
    }}
