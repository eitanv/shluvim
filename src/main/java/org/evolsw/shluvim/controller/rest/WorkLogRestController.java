package org.evolsw.shluvim.controller.rest;

import org.evolsw.shluvim.controller.services.WorkLogServices;
import org.evolsw.shluvim.model.WorkLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/worklogs")
public class WorkLogRestController {

    @Autowired
    WorkLogServices workLogServices;

    @GetMapping("/")
    ResponseEntity<List<WorkLog>> getAllInstructors() {
        List<WorkLog> allWorkLogs = workLogServices.loadAll();
        System.out.println("All work logs: " + Arrays.toString(allWorkLogs.toArray()));
        return new ResponseEntity<>(allWorkLogs, HttpStatus.OK);
    }

    @PostMapping("/")
    ResponseEntity<WorkLog> logWork(@RequestBody WorkLog workLog) {
        WorkLog newlog = workLogServices.save(workLog);
        System.out.println("Adding work log: " + newlog);
        return new ResponseEntity<>(newlog, HttpStatus.OK);
    }
}
