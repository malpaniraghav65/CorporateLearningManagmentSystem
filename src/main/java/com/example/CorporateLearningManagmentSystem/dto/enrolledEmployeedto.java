package com.example.CorporateLearningManagmentSystem.dto;

import lombok.Data;

@Data
public class enrolledEmployeedto {
    int emp_id;
    int course_id;
    Float Status;
    String startdate;
    String enddate;

    public enrolledEmployeedto(int emp_id, int course_id, float status, String startdate, String enddate) {
        this.emp_id = emp_id;
        this.course_id = course_id;
        Status = status;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public enrolledEmployeedto() {
    }
}
