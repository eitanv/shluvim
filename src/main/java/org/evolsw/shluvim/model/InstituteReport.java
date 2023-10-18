package org.evolsw.shluvim.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "INSTITUTE_REPORTS")
@Data
@SequenceGenerator(name = "start@100001", sequenceName = "start@100001", initialValue = 100001)
public class InstituteReport {

    public InstituteReport(Long instituteId, int logYear, int logMonth, String totalHours, double totalCharge) {
        this.instituteId = instituteId;
        this.logYear = logYear;
        this.logMonth = logMonth;
        this.totalHours = totalHours;
        this.totalCharge = totalCharge;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "start@100001")
    Long reportId;
    int logYear;
    int logMonth;
    String totalHours;
    double totalCharge;
    Long instituteId;
}
