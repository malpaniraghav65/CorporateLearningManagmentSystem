package com.example.CorporateLearningManagmentSystem.service.impl;


import com.example.CorporateLearningManagmentSystem.dto.AssignRmToEmpDto;
import com.example.CorporateLearningManagmentSystem.entity.AssignRmToEmp;
import com.example.CorporateLearningManagmentSystem.entity.User;
import com.example.CorporateLearningManagmentSystem.repository.AssignRmToEmpRepo;
import com.example.CorporateLearningManagmentSystem.service.AssignRmToEmpService;
import com.example.CorporateLearningManagmentSystem.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AssignRmToEmpServiceimpl implements AssignRmToEmpService {
    @Autowired
    private final AssignRmToEmpRepo assignRmToEmpRepo;
    @Autowired
    private final UserService userService;


    public AssignRmToEmpServiceimpl(AssignRmToEmpRepo assignRmToEmpRepo, UserService userService) {
        this.assignRmToEmpRepo = assignRmToEmpRepo;
        this.userService = userService;

    }

    @Override
    public AssignRmToEmp findByEmployeeId(int employeeId) {
        return assignRmToEmpRepo.findByEmployee_Id(employeeId);
    }

    @Transactional
    @Override
    public AssignRmToEmp createAssignment(AssignRmToEmpDto assignRmToEmpDto) {
        User reportingManager = userService.getUserByIdAndRoleTwo(assignRmToEmpDto.getReportmanagerId());
        User employee = userService.getUserByIdAndRoleThree(assignRmToEmpDto.getEmployeeId());

        AssignRmToEmp existingAssignment = assignRmToEmpRepo.findByEmployee_Id(employee.getId());
        // Check if the assignment already exists for the given employee
        if (existingAssignment != null && existingAssignment.getRmId() != reportingManager.getId()) {
            throw new RuntimeException("Employee with ID " + employee.getId() + " is already assigned to a different reporting manager.");
        }
        // Check if empId is already present in AssignRmToEmp
        AssignRmToEmp existingAssignmentForEmpId = assignRmToEmpRepo.findByEmployee_Id(assignRmToEmpDto.getEmployeeId());
        if (existingAssignmentForEmpId != null) {
            throw new RuntimeException("Employee with ID " + assignRmToEmpDto.getEmployeeId() + " already has an assignment.");
        }

        AssignRmToEmp assignment = new AssignRmToEmp();
        assignment.setEmpId(assignRmToEmpDto.getEmployeeId());
        assignment.setRmId(assignRmToEmpDto.getReportmanagerId());
            return assignRmToEmpRepo.save(assignment);
        }

    }

//    public AssignRmToEmp createAssignment(int reportmanagerId, int employeeId) {
//        User reportingManager = userService.getUserByIdAndRoleTwo(reportmanagerId);
//        User employee = userService.getUserByIdAndRoleThree(employeeId);
//        if (assignRmToEmpRepo.existsByEmployee(employeeId)) {
//            throw new RuntimeException("Employee already has a report manager.");
//        }
//        AssignRmToEmp assignment = new AssignRmToEmp();
//        assignment.setReportmanager(reportingManager);
//        assignment.setEmployee(employee);
////        System.out.println(reportingManager);
////        System.out.println(reportmanagerId);/
////        System.out.println(employeeId);
////        return assignRmToEmpRepo.save(assignment);
//        return assignRmToEmpRepo.save(assignment);
//    }
////    public AssignRmToEmp saveAssignment(AssignRmToEmp assignment) {
////        return assignRmToEmpRepo.save(assignment);
////    }
//
//    @Override
//    public AssignRmToEmp findByEmployeeId(int employeeId) {
//        return assignRmToEmpRepo.findByEmployee_Id(employeeId);
////        return AssignRmToEmp(userService.getUserById());
////        return null;
//    }

