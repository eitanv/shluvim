package org.evolsw.shluvim.controller.services;

import org.evolsw.shluvim.model.Institute;
import org.evolsw.shluvim.model.Instructor;

import java.util.List;

public interface InstututeServices {

    List<Institute> loadAll();
    Institute load(Long id);
    Institute save(Institute institute);

}
