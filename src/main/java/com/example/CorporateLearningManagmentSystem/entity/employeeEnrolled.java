package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;
import jdk.jfr.Percentage;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee_enrolled")
public class employeeEnrolled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(name = "status")
    private Float status;

    @Column(name = "startdate")
    private String startdate;

    @Column(name = "enddate")
    private String enddate;




}
