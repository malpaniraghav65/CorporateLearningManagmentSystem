package com.example.CorporateLearningManagmentSystem.controller;

import com.example.CorporateLearningManagmentSystem.service.ServiceUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class Controller {
    @Autowired
    public ServiceUserRole serviceUserRole;





}
