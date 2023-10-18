package org.evolsw.shluvim.controller.services;

import org.evolsw.shluvim.model.Institute;
import org.evolsw.shluvim.model.Instructor;

import java.time.Duration;

public interface CostServices {

    double calculateHourFinalCost(Institute institute, Instructor instructor);

    double calculateInstructorsCharge(double cost, Duration hours);
}
