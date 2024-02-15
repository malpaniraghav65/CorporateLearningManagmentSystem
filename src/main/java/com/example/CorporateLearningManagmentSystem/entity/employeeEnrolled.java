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

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Float getStatus() {
        return status;
    }

    public void setStatus(Float status) {
        this.status = status;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }


    public employeeEnrolled(Long id, User user, Course course, Float status, String startdate, String enddate) {
        Id = id;
        this.user = user;
        this.course = course;
        this.status = status;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public employeeEnrolled() {
    }
}
