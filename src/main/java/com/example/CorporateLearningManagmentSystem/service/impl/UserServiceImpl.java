package com.example.CorporateLearningManagmentSystem.service.impl;


import com.example.CorporateLearningManagmentSystem.dto.userDto;
import com.example.CorporateLearningManagmentSystem.entity.Role;
import com.example.CorporateLearningManagmentSystem.entity.User;
import com.example.CorporateLearningManagmentSystem.entity.UserRole;
import com.example.CorporateLearningManagmentSystem.repository.RoleRepo;
import com.example.CorporateLearningManagmentSystem.repository.UserRepo;
import com.example.CorporateLearningManagmentSystem.repository.UserRoleRepo;
import com.example.CorporateLearningManagmentSystem.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;
    private final RoleRepo roleRepository;
    private final UserRoleRepo userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepo userRepository, RoleRepo roleRepository, UserRoleRepo userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void createUserWithRole(userDto userDt) {
        User user = new User();
        user.setName(userDt.getName());
        user.setEmail(userDt.getEmail());
        user.setPassword(userDt.getPassword());

        Role role = roleRepository.findById(userDt.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        userRepository.save(user);

        UserRole userRole = new UserRole(user ,role);
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepository.save(userRole);
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
        userRepository.delete(userId);
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
//            userRoleRepository.delete(user);

        } else {
            throw new RuntimeException("User not found");
        }
    }
}

