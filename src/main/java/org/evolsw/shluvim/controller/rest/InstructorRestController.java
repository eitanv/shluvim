package org.evolsw.shluvim.controller.rest;

import org.evolsw.shluvim.controller.services.InstructorServices;
import org.evolsw.shluvim.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorRestController {

    @Autowired
    InstructorServices instructorServices;

    @GetMapping("/")
    ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> allInstructors = instructorServices.loadAll();
        System.out.println("All instructors: " + Arrays.toString(allInstructors.toArray()));
        return new ResponseEntity<>(allInstructors, HttpStatus.OK);
    }
}
