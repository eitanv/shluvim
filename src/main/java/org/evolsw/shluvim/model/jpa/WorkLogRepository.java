package org.evolsw.shluvim.model.jpa;

import org.evolsw.shluvim.model.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface WorkLogRepository extends JpaRepository<WorkLog, Long> {
}
