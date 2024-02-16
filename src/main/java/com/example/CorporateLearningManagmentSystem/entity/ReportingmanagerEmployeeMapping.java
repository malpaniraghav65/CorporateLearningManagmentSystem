package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ReportingmanagerEmployee")
public class ReportingmanagerEmployeeMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "RM_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Emp_id")
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ReportingmanagerEmployeeMapping(int id, User user, Role role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }
}
