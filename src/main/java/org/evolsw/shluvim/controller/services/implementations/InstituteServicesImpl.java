package org.evolsw.shluvim.controller.services.implementations;

import org.evolsw.shluvim.controller.services.InstututeServices;
import org.evolsw.shluvim.model.Institute;
import org.evolsw.shluvim.model.jpa.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstituteServicesImpl implements InstututeServices {

    @Autowired
    InstituteRepository instituteRepository;

    @Override
    public List<Institute> loadAll() {
        return instituteRepository.findAll();
    }

    @Override
    public Institute load(Long id) {
        return instituteRepository.getReferenceById(id);
    }

    @Override
    public Institute save(Institute institute) {
        return instituteRepository.save(institute);
    }

    @Override
    public double getBaseCost(Long id) {
        return instituteRepository.getReferenceById(id).getBaseCost();
    }


}
