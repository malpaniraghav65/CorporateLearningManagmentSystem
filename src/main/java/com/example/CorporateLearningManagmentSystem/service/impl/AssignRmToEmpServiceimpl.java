package com.example.CorporateLearningManagmentSystem.service.impl;


import com.example.CorporateLearningManagmentSystem.entity.AssignRmToEmp;
import com.example.CorporateLearningManagmentSystem.entity.User;
import com.example.CorporateLearningManagmentSystem.repository.AssignRmToEmpRepo;
import com.example.CorporateLearningManagmentSystem.service.AssignRmToEmpService;
import com.example.CorporateLearningManagmentSystem.service.UserService;
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
    @Override
    public AssignRmToEmp createAssignment(int reportmanagerId, int employeeId) {
        User reportingManager = userService.getUserByIdAndRoleTwo(reportmanagerId);
        User employee = userService.getUserByIdAndRoleThree(employeeId);

//        System.out.println("Hello world");
//        System.out.println(reportingManager.getId());
//        System.out.println(employee.getId());
        AssignRmToEmp existingAssignment = assignRmToEmpRepo.findByEmployee_Id(employee.getId());

        if (existingAssignment != null && existingAssignment.getReportmanager().getId() != reportmanagerId) {
            throw new RuntimeException("Employee with ID " + employeeId + " is already assigned to a different reporting manager.");
        }

        AssignRmToEmp assignment = new AssignRmToEmp();
        assignment.setReportmanager(reportingManager);
        assignment.setEmployee(employee);

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

