package org.evolsw.shluvim.controller.rest;

import org.evolsw.shluvim.controller.dto.InstituteReportRequest;
import org.evolsw.shluvim.controller.dto.InstituteReportResponse;
import org.evolsw.shluvim.controller.services.ReportServices;
import org.evolsw.shluvim.model.InstituteReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportsRestController {

    @Autowired
    ReportServices reportServices;

    @PostMapping("institute")
    ResponseEntity<InstituteReportResponse> getInstituteReport(@RequestBody InstituteReportRequest request) {
        InstituteReportResponse response = reportServices.generateInstituteReport(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
