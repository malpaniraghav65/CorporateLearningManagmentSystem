package com.example.CorporateLearningManagmentSystem.dto;

public class userDto {
    private String name;
    private String email;
    private String password;
    private int roleId;
    private int reportingmanager_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;

    }

    public int getReportingmanager_id() {
        return reportingmanager_id;
    }

    public void setReportingmanager_id(int reportingmanager_id) {
        this.reportingmanager_id = reportingmanager_id;
    }

    public userDto(String name, String email, String password, int roleId, int reportingmanager_id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.reportingmanager_id = reportingmanager_id;
    }

    public userDto() {
    }
}
