package org.evolsw.shluvim.controller.services.implementations;

import org.evolsw.shluvim.controller.dto.InstituteReportRequest;
import org.evolsw.shluvim.controller.dto.InstituteReportResponse;
import org.evolsw.shluvim.controller.dto.InstructorReportResponse;
import org.evolsw.shluvim.controller.services.*;
import org.evolsw.shluvim.model.InstituteReport;
import org.evolsw.shluvim.model.WorkLog;
import org.evolsw.shluvim.model.jpa.InstituteReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServicesImpl implements ReportServices {

    @Autowired
    InstituteReportRepository instituteReportRepository;
    @Autowired
    InstututeServices instututeServices;

    @Autowired
    WorkLogServices workLogServices;

    @Autowired
    InstructorServices instructorServices;

    @Autowired
    CostServices costServices;

    @Override
    public InstituteReportResponse generateInstituteReport(InstituteReportRequest request) {

        InstituteReportResponse instituteReportResponse = new InstituteReportResponse();
        instituteReportResponse.setTotalHours("00:00");

        List<WorkLog> allReportLines = workLogServices.loadForInstituteReport(request.getInstituteId(), request.getYear(), request.getMonth());
        System.out.println("All report Lines: " + Arrays.toString(allReportLines.toArray()));

        Map<String, InstructorReportResponse> instructorsMap = new HashMap<>();
        for (WorkLog workLog : allReportLines) {
            String key = workLog.getInstructorId() + "_" + workLog.getLogDay();
            if (!instructorsMap.containsKey(key)) {
                InstructorReportResponse instructorReportResponse = new InstructorReportResponse();
                instructorReportResponse.setInstructorId(workLog.getInstructorId());
                instructorReportResponse.setDay(workLog.getLogDay());
                Duration instructorMinutes = workLogServices.calculateMinutes(workLog.getStartWork(), workLog.getEndWork());
                instructorReportResponse.setInstructorHours(workLogServices.formatDuration(instructorMinutes));
                double instructorCost = costServices.calculateHourFinalCost(instututeServices.load(request.getInstituteId()), instructorServices.load(workLog.getInstructorId()));
                double instructorCharge = costServices.calculateInstructorsCharge(instructorCost, instructorMinutes);
                instructorReportResponse.setInstructorsCharge(instructorCharge);
                instructorsMap.put(key, instructorReportResponse);
                String totalHours = workLogServices.addToExisting(instituteReportResponse.getTotalHours(), instructorMinutes);

                instituteReportResponse.setTotalHours(totalHours);
                instituteReportResponse.setTotalCharge(instituteReportResponse.getTotalCharge() + instructorCharge);

            } else {
                InstructorReportResponse instructorReportResponse = instructorsMap.get(key);

                Duration instructorMinutes = workLogServices.calculateMinutes(workLog.getStartWork(), workLog.getEndWork());
                instructorReportResponse.setInstructorHours(workLogServices.addToExisting(instructorReportResponse.getInstructorHours(), instructorMinutes));
                double instructorCost = costServices.calculateHourFinalCost(instututeServices.load(request.getInstituteId()), instructorServices.load(workLog.getInstructorId()));
                double instructorCharge = costServices.calculateInstructorsCharge(instructorCost, instructorMinutes);
                instructorReportResponse.setInstructorsCharge(
                        instructorReportResponse.getInstructorsCharge() +
                                instructorCharge);

                String totalHours = workLogServices.addToExisting(instituteReportResponse.getTotalHours(), instructorMinutes);
                instituteReportResponse.setTotalHours(totalHours);
                instituteReportResponse.setTotalCharge(instituteReportResponse.getTotalCharge() + instructorCharge);
            }
        }

        List<InstructorReportResponse> instructorReportResponseList = instructorsMap.values().stream().toList();
        instituteReportResponse.setInstructorReportResponseList(instructorReportResponseList);

        InstituteReport instituteReport = new InstituteReport(
                request.getInstituteId(),
                request.getYear(),
                request.getMonth(),
                instituteReportResponse.getTotalHours(),
                instituteReportResponse.getTotalCharge()
        );
        instituteReport = instituteReportRepository.save(instituteReport);
        instituteReportResponse.setReportId(instituteReport.getReportId());
        return instituteReportResponse;
    }

}
