package org.evolsw.shluvim.controller.services.implementations;

import org.evolsw.shluvim.controller.services.WorkLogServices;
import org.evolsw.shluvim.model.WorkLog;
import org.evolsw.shluvim.model.jpa.WorkLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
