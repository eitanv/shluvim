package org.evolsw.shluvim.controller.dto;

import lombok.Data;

import java.sql.Time;

@Data
public class InstructorReportResponse {
    Long instructorId;
    int day;
    String instructorHours;
    double instructorsCharge;
}
