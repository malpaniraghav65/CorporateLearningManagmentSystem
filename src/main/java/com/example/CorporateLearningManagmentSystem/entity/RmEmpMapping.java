package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

@Entity
public class RmEmpMapping {

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
