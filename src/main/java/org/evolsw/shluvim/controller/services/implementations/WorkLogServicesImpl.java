package org.evolsw.shluvim.controller.services.implementations;

import org.evolsw.shluvim.controller.services.WorkLogServices;
import org.evolsw.shluvim.model.WorkLog;
import org.evolsw.shluvim.model.jpa.WorkLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;


@Service
public class WorkLogServicesImpl implements WorkLogServices {

    @Autowired
    WorkLogRepository workLogRepository;

    @Override
    public List<WorkLog> loadAll() {
        return workLogRepository.findAll();
    }

    @Override
    public WorkLog load(Long id) {
        return workLogRepository.getReferenceById(id);
    }

    @Override
    public WorkLog save(WorkLog workLog) {
        return workLogRepository.save(workLog);
    }

    @Override
    public List<WorkLog> loadForInstituteReport(Long instituteId, int year, int month) {
        return workLogRepository.findByInstituteIdAndLogYearAndLogMonth(instituteId, year, month);
    }

    @Override
    public Duration calculateMinutes(Time startWork, Time endWork) {
        LocalTime startWorkLocal = startWork.toLocalTime();
        LocalTime endWorkLocal = endWork.toLocalTime();
        return Duration.between(startWorkLocal, endWorkLocal);
    }

    @Override
    public String addToExisting(String existing, Duration more) {

        String hours = existing.split(":")[0];
        String mins = existing.split(":")[1];
        String toparse = "PT" + hours + "H" + mins + "M";
        Duration existingDuration = Duration.parse(toparse);
        return formatDuration(existingDuration.plus(more));

    }

    @Override
    public String formatDuration(Duration hoursMinutes) {
        return String.format("%d:%02d", hoursMinutes.toHours(), hoursMinutes.toMinutes() - hoursMinutes.toHours() * 60);
    }

}
