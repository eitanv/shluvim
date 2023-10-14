package org.evolsw.shluvim.model.jpa;

import org.evolsw.shluvim.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface InstituteRepository extends JpaRepository<Institute, Long> {
}
