package org.evolsw.shluvim.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity
@Table(name = "WORK_LOGS")
@Data
@SequenceGenerator(name = "start@10001", sequenceName = "start@10001", initialValue = 100001)
public class WorkLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "start@10001")
    Long workLogId;
    int logYear;
    int logMonth;
    int logDay;
    Time startWork;
    Time endWork;
    Long instructorId;
    Long instituteId;

}
