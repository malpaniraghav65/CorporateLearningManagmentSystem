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

    private final EnrollEmployeeService enrollService;
    //private final EmployeeEnrolledService enrolledService;

    @Autowired
    public enrolldata(EnrollEmployeeService enrolledService) {
        this.enrollService = enrolledService;
    }
    @GetMapping
    public List<enrolledEmployeedto> getEnrolledEmployees(){
        return enrollService.getEnrolledEmployees();
    }}
