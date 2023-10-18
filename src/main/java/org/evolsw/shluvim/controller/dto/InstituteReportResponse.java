package org.evolsw.shluvim.controller.dto;

import lombok.Data;

import java.sql.Time;
import java.util.List;

@Data
public class InstituteReportResponse {

    Long reportId;
    String totalHours;
    double totalCharge;
    List<InstructorReportResponse> instructorReportResponseList;
}
