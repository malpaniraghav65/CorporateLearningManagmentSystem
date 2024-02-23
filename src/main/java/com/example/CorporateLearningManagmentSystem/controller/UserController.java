package com.example.CorporateLearningManagmentSystem.controller;


import com.example.CorporateLearningManagmentSystem.dto.userDto;
import com.example.CorporateLearningManagmentSystem.entity.User;
import com.example.CorporateLearningManagmentSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody userDto userDt) {
        userService.updateUser(userId, userDt);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createUserWithRole(@RequestBody userDto userDt) {
        userService.createUserWithRole(userDt);
        return new ResponseEntity<>("User created with role successfully", HttpStatus.CREATED);
    }





//
//    @PostMapping("/assign")
//    public ResponseEntity<String> assignReportManagerToEmployee(
//            @RequestParam Long reportManagerId,
//            @RequestParam Long employeeId,
//            @RequestParam Long requestingUserId) {
//        try {
//            userService.assignReportManagerToEmployee(reportManagerId, employeeId, requestingUserId);
//            return new ResponseEntity<>("Report manager assigned to employee successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }


