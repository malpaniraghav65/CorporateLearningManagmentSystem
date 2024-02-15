package com.example.CorporateLearningManagmentSystem.controller;


import com.example.CorporateLearningManagmentSystem.dto.userDto;
import com.example.CorporateLearningManagmentSystem.entity.User;
import com.example.CorporateLearningManagmentSystem.service.UserService;
import com.example.CorporateLearningManagmentSystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class Controller {

    private final UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }


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

}
