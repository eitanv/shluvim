package org.evolsw.shluvim.controller.services.implementations;

import org.evolsw.shluvim.controller.services.CostServices;
import org.evolsw.shluvim.model.Institute;
import org.evolsw.shluvim.model.Instructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class CostServicesImpl implements CostServices {
    @Override
    public double calculateHourFinalCost(Institute institute, Instructor instructor) {
        return institute.getBaseCost() + instructor.getHourSalary();
    }

    @Override
    public double calculateInstructorsCharge(double cost, Duration minutes) {
        return minutes.toMinutes() * cost / 60;
    }
}
