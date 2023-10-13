package org.evolsw.shluvim.controller.services;

import org.evolsw.shluvim.model.Instructor;

import java.util.List;

public interface InstructorServices {

    List<Instructor> loadAll();
    Instructor load(Long id);
    Instructor save(Instructor instructor);

}
