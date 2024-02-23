package com.example.CorporateLearningManagmentSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reportingmanager_employee")
public class AssignRmToEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "emp_id")
    //    @ManyToOne(cascade = CascadeType.PERSIST)
    //    @JoinColumn(name = "rmd")
    private int rmId;


    public AssignRmToEmp() {

    }

    private int empId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRmId() {
        return rmId;
    }

    public void setRmId(int rmId) {
        this.rmId = rmId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public AssignRmToEmp(int id, int rmId, int empId) {
        this.id = id;
        this.rmId = rmId;
        this.empId = empId;
    }
}
