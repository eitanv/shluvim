package org.evolsw.shluvim.controller.rest;

import org.evolsw.shluvim.controller.services.InstructorServices;
import org.evolsw.shluvim.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}/salary={salary}")
    public ResponseEntity<String> updateInstructorCost(@PathVariable Long id, @PathVariable double salary) {
        Instructor instructor = instructorServices.load(id);
        instructor.setHourSalary(salary);
        instructorServices.save(instructor);
        System.out.println("Updated " + instructor.getName() + "`s Salary to " + salary);
        return new ResponseEntity<>("Updated cost", HttpStatus.OK);
    }
}
