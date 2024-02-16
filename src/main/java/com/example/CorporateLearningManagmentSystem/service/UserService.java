package com.example.CorporateLearningManagmentSystem.service;

import com.example.CorporateLearningManagmentSystem.dto.userDto;
import com.example.CorporateLearningManagmentSystem.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{
    void createUserWithRole(userDto userdto);

    User getUserById(int userId);

    List<User> getAllUsers();

    void updateUser(int userId, userDto userDt);

    void deleteUser(int userId);
}
