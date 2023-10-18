package org.evolsw.shluvim.controller.services;

import org.evolsw.shluvim.model.WorkLog;

import java.sql.Time;
import java.time.Duration;
import java.util.List;

public interface WorkLogServices {
    List<WorkLog> loadAll();

    WorkLog load(Long id);

    WorkLog save(WorkLog workLog);

    List<WorkLog> loadForInstituteReport(Long instituteId, int logYear, int month);

    Duration calculateMinutes(Time startWork, Time endWork);

    String addToExisting(String existing, Duration more);

    public String formatDuration (Duration hoursMinutes);

}
