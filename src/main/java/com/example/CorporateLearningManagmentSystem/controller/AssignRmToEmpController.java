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
    public ResponseEntity<String> assignEmployeeToReportingManager(
//            @RequestParam(value = "reportmanagerId", required = true) int reportmanagerId,
//            @RequestParam(value = "employeeId", required = true) int employeeId

            @RequestBody AssignRmToEmpDto assignRmToEmpDto
            ) {


        assignRmToEmpService.createAssignment(assignRmToEmpDto);
        return ResponseEntity.ok("Employee assigned to reporting manager successfully.");

    }
}


//    @PostMapping("/")
//    public ResponseEntity<String> assignEmployeeToReportingManager(
//            @RequestParam(value = "reportmanagerId", required = true) int reportmanagerId,
//            @RequestParam(value = "employeeId", required = true) int employeeId
//    ) {
//
//            AssignRmToEmp assignment = assignRmToEmpService.createAssignment(reportmanagerId, employeeId);
//
//            if (userService.hasRoleId(assignment.getReportmanager(), 2)) {
//                assignRmToEmpService.saveAssignment(assignment);
//                return ResponseEntity.ok("Employee assigned to reporting manager successfully.");
//            } else {
//                return ResponseEntity.badRequest().body("User with ID " + reportmanagerId + " is not a reporting manager.");
//            }
//
//    }
//}

