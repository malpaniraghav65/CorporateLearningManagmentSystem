package com.example.CorporateLearningManagmentSystem.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userDto {
    private String name;
    private String email;
    private String password;
    private int roleId;

    public userDto() {
    }

    public userDto(String name, String email, String password, int roleId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }
}

