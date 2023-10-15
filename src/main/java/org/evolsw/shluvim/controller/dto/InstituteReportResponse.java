package org.evolsw.shluvim.controller.dto;

import lombok.Data;

import java.sql.Time;
import java.util.List;

@Data
public class InstituteReportResponse {

    Long reportId;
    Time totalHours;
    double totalCharge;
    List<InstructorReportResponse> instructorReportResponseList;
}
