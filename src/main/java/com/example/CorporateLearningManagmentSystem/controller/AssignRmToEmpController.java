package com.example.CorporateLearningManagmentSystem.controller;

//import com.example.CorporateLearningManagmentSystem.entity.AssignRmToEmp;
import com.example.CorporateLearningManagmentSystem.dto.AssignRmToEmpDto;
import com.example.CorporateLearningManagmentSystem.entity.User;
import com.example.CorporateLearningManagmentSystem.service.AssignRmToEmpService;
import com.example.CorporateLearningManagmentSystem.service.UserService;
import com.example.CorporateLearningManagmentSystem.service.impl.AssignRmToEmpServiceimpl;
import com.example.CorporateLearningManagmentSystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/assign")
public class AssignRmToEmpController {
@Autowired
private  AssignRmToEmpService assignRmToEmpService;
@Autowired
private  UserService userService;
    @PostMapping("/")
    public ResponseEntity<String> assignEmployeeToReportingManager(@RequestBody AssignRmToEmpDto assignRmToEmpDto) {
        assignRmToEmpService.createAssignment(assignRmToEmpDto);
        return ResponseEntity.ok("Employee assigned to reporting manager successfully.");
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteAssignment(@PathVariable int empId) {
        assignRmToEmpService.deleteAssignment(empId);
        return ResponseEntity.ok("employee are free , deleted for assign reportmanager");
    }


}


