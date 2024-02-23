package com.example.CorporateLearningManagmentSystem.service.impl;


import com.example.CorporateLearningManagmentSystem.dto.userDto;
//import com.example.CorporateLearningManagmentSystem.entity.AssignRmToEmp;
import com.example.CorporateLearningManagmentSystem.entity.Role;
import com.example.CorporateLearningManagmentSystem.entity.User;
//import com.example.CorporateLearningManagmentSystem.repository.AssignRmToEmpRepo;
import com.example.CorporateLearningManagmentSystem.repository.AssignRmToEmpRepo;
import com.example.CorporateLearningManagmentSystem.repository.RoleRepo;
import com.example.CorporateLearningManagmentSystem.repository.UserRepo;

import com.example.CorporateLearningManagmentSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo userRepository;
    @Autowired
    private final RoleRepo roleRepository;

    @Autowired
    private final AssignRmToEmpRepo assignRmToEmpRepo;


    public UserServiceImpl(UserRepo userRepository, RoleRepo roleRepository, AssignRmToEmpRepo assignRmToEmpRepo) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.assignRmToEmpRepo = assignRmToEmpRepo;
    }


    @Override
    public void createUserWithRole(userDto userDt) {
        User user = new User();
        user.setName(userDt.getName());
        user.setEmail(userDt.getEmail());
        user.setPassword(userDt.getPassword());

        Role role = roleRepository.findById(userDt.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.getRoles().add(role);  // Add the role to the user's roles

        userRepository.save(user);
    }


    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(int userId, userDto userDt) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update user fields as needed
        user.setName(userDt.getName());
        user.setEmail(userDt.getEmail());
        user.setPassword(userDt.getPassword());

        // Save the updated user
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        // Delete user and associated roles

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);

        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User getUserByIdAndRoleTwo(int reportmangerId) {
        int roleId = 2; // Assuming role_id 2 is for reporting manager

        User user = userRepository.findById(reportmangerId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRoles().stream().anyMatch(role -> role.getId() == roleId)) {
            return user;
        } else {
            throw new RuntimeException("User does not have the required role");
        }
    }

    @Override
    public User getUserByIdAndRoleThree(int employeeId) {
        int roleId = 3; // Assuming role_id 2 is for reporting manager

        User user = userRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRoles().stream().anyMatch(role -> role.getId() == roleId)) {
            return user;
        } else {
            throw new RuntimeException("User does not have the required role");
        }
    }

    @Override
    public boolean hasRoleId(User user, int roleId) {
        Set<Role> userRoles = user.getRoles();
        for (Role role : userRoles) {
            if (role.getId() == roleId) {
                return true;
            }
        }
        return false;
    }
}
