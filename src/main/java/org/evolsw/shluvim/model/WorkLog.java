package org.evolsw.shluvim.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity
@Table(name = "WORK_LOGS")
@Data
@SequenceGenerator(name = "start@10000", sequenceName = "start@10000", initialValue = 100001)
public class WorkLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "start@10000")
    Long workLogId;
    int logYear;
    int logMonth;
    int logDay;
    Time startWork;
    Time endWork;
    Long instructorId;

}
