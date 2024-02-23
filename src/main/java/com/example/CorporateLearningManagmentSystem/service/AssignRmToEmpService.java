package com.example.CorporateLearningManagmentSystem.service;

import com.example.CorporateLearningManagmentSystem.dto.AssignRmToEmpDto;
import org.springframework.stereotype.Service;
import com.example.CorporateLearningManagmentSystem.entity.AssignRmToEmp;

@Service
public interface AssignRmToEmpService {

     AssignRmToEmp createAssignment(AssignRmToEmpDto assignRmToEmpDto);
//    public AssignRmToEmp saveAssignment(AssignRmToEmp assignment);

     AssignRmToEmp findByEmployeeId(int employeeId);
}
