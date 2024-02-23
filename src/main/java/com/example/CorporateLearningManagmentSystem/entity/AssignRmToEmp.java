package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reportingmanager_employee")
public class AssignRmToEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rm_id")
    private User Reportmanager;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private User employee;

    public AssignRmToEmp() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getReportmanager() {
        return Reportmanager;
    }

    public void setReportmanager(User reportmanager) {
        reportmanager = reportmanager;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        employee = employee;
    }

    public AssignRmToEmp(int id, User reportmanager, User employee) {
        this.id = id;
        this.Reportmanager = reportmanager;
        this.employee = employee;
    }
}
