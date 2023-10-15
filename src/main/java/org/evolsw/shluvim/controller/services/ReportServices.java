package org.evolsw.shluvim.controller.services;

import org.evolsw.shluvim.controller.dto.InstituteReportRequest;
import org.evolsw.shluvim.controller.dto.InstituteReportResponse;

public interface ReportServices {
    InstituteReportResponse generateInstituteReport(InstituteReportRequest request);

}
