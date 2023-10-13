package org.evolsw.shluvim.controller.services.implementations;

import org.evolsw.shluvim.controller.services.InstructorServices;
import org.evolsw.shluvim.model.Instructor;
import org.evolsw.shluvim.model.jpa.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorServicesImpl implements InstructorServices {

    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public List<Instructor> loadAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor load(Long id) {
        return instructorRepository.getReferenceById(id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
}
