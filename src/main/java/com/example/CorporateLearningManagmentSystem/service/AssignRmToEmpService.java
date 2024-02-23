package com.example.CorporateLearningManagmentSystem.service;

import org.springframework.stereotype.Service;
import com.example.CorporateLearningManagmentSystem.entity.AssignRmToEmp;

@Service
public interface AssignRmToEmpService {

     AssignRmToEmp createAssignment(int reportmanagerId, int employeeId);
//    public AssignRmToEmp saveAssignment(AssignRmToEmp assignment);

     AssignRmToEmp findByEmployeeId(int employeeId);
}
