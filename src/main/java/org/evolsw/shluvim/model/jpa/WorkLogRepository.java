package org.evolsw.shluvim.model.jpa;

import org.evolsw.shluvim.model.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkLogRepository extends JpaRepository<WorkLog, Long> {

    List<WorkLog> findByInstituteIdAndLogYearAndLogMonth(Long instituteId, int logYear, int logMonth);

}
