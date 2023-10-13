package org.evolsw.shluvim.controller.services;

import org.evolsw.shluvim.model.WorkLog;

import java.util.List;

public interface WorkLogServices {
    List<WorkLog> loadAll();

    WorkLog load(Long id);

    WorkLog save(WorkLog workLog);

}
