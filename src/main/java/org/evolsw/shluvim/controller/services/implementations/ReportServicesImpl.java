package org.evolsw.shluvim.controller.services.implementations;

import org.evolsw.shluvim.controller.dto.InstituteReportRequest;
import org.evolsw.shluvim.controller.dto.InstituteReportResponse;
import org.evolsw.shluvim.controller.dto.InstructorReportResponse;
import org.evolsw.shluvim.controller.services.InstructorServices;
import org.evolsw.shluvim.controller.services.InstututeServices;
import org.evolsw.shluvim.controller.services.ReportServices;
import org.evolsw.shluvim.model.InstituteReport;
import org.evolsw.shluvim.model.Instructor;
import org.evolsw.shluvim.model.WorkLog;
import org.evolsw.shluvim.model.jpa.InstituteReportRepository;
import org.evolsw.shluvim.model.jpa.WorkLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReportServicesImpl implements ReportServices {

    @Autowired
    InstituteReportRepository instituteReportRepository;
    @Autowired
    InstututeServices instututeServices;

    @Autowired
    WorkLogRepository workLogRepository;

    @Autowired
    InstructorServices instructorServices;

    @Override
    public InstituteReportResponse generateInstituteReport(InstituteReportRequest request) {

        InstituteReportResponse instituteReportResponse = new InstituteReportResponse();
        //calculate report
        Time totalHours = Time.valueOf("5:46:00");
        instituteReportResponse.setTotalHours(totalHours);
        double instituteBaseCost = instututeServices.getBaseCost(request.getInstituteId());
        System.out.println("Base Cost: " + String.valueOf(instituteBaseCost));
        Instructor oneOfTheInstructors = instructorServices.load(1001L);
        System.out.println("Instructors hourSalary: " + String.valueOf(oneOfTheInstructors.getHourSalary()));
        System.out.println("Instructors name: " + oneOfTheInstructors.getName());
        List<WorkLog> allReportLines = workLogRepository.findByInstituteIdAndLogYearAndLogMonth(request.getInstituteId(), request.getYear(), request.getMonth());
        System.out.println("All report Lines: " + Arrays.toString(allReportLines.toArray()));
        instituteReportResponse.setTotalCharge(304.04);

        List<InstructorReportResponse> instructorReportResponseList = new ArrayList<>();
        //calculate
        InstructorReportResponse instructorReportResponse = new InstructorReportResponse();
        instructorReportResponse.setInstructorId(1001L);
        instructorReportResponse.setDay(3);
        instructorReportResponse.setInstructorHours(totalHours);
        instructorReportResponse.setInstructorsCharge(120.9);
        instructorReportResponseList.add(instructorReportResponse);
        instituteReportResponse.setInstructorReportResponseList(instructorReportResponseList);

        InstituteReport instituteReport = new InstituteReport(
                request.getInstituteId(),
                request.getYear(),
                request.getMonth(),
                totalHours,
                304.04
        );
        instituteReport = instituteReportRepository.save(instituteReport);
        instituteReportResponse.setReportId(instituteReport.getReportId());
        return instituteReportResponse;
    }
}
