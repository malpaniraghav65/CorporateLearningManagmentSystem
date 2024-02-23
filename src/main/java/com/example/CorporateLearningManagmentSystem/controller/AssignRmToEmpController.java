package com.example.CorporateLearningManagmentSystem.controller;

//import com.example.CorporateLearningManagmentSystem.entity.AssignRmToEmp;
import com.example.CorporateLearningManagmentSystem.entity.User;
import com.example.CorporateLearningManagmentSystem.service.AssignRmToEmpService;
import com.example.CorporateLearningManagmentSystem.service.UserService;
import com.example.CorporateLearningManagmentSystem.service.impl.AssignRmToEmpServiceimpl;
import com.example.CorporateLearningManagmentSystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/assign")
public class AssignRmToEmpController {
@Autowired
private  AssignRmToEmpService assignRmToEmpService;
@Autowired
private  UserService userService;




// Controller

    @PostMapping("/")
    public ResponseEntity<String> assignEmployeeToReportingManager(
            @RequestParam(value = "reportmanagerId", required = true) int reportmanagerId,
            @RequestParam(value = "employeeId", required = true) int employeeId
    ) {
       // User reportManager = userService.getUserByIdAndRoleTwo(reportmanagerId);
       // System.out.println(reportManager+"controller class");
//        if (!userService.hasRoleId(reportManager, 2)) {
//            return ResponseEntity.badRequest().body("User with ID " + reportmanagerId + " is not a reporting manager.");
//        }

        assignRmToEmpService.createAssignment(reportmanagerId, employeeId);
        return ResponseEntity.ok("Employee assigned to reporting manager successfully.");
//        AssignRmToEmp existingAssignment = assignRmToEmpService.findByEmployeeId(employeeId);
//
//        if (existingAssignment != null && existingAssignment.getEmployee().getId() != reportmanagerId) {
//            return ResponseEntity.badRequest().body("Employee with ID " + employeeId + " is already assigned to a different reporting manager.");
//        }
//
//     assignRmToEmpService.createAssignment(reportmanagerId,employeeId);
//        return ResponseEntity.ok("Employee assigned to reporting manager successfully.");
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

