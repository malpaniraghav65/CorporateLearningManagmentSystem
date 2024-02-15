package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ReportingmanagerEmployee")
public class ReportingmanagerEmployeeMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "RM_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Emp_id")
    private Role role;

}
