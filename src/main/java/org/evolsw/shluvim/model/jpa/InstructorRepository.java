package org.evolsw.shluvim.model.jpa;

import org.evolsw.shluvim.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
