package org.evolsw.shluvim.controller.rest;

import org.evolsw.shluvim.controller.services.InstututeServices;
import org.evolsw.shluvim.model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/institutes")
public class InstituteRestController {

    @Autowired
    InstututeServices instututeServices;

    @GetMapping("/")
    ResponseEntity<List<Institute>> getAllInstitutes() {
        List<Institute> allInstitutes = instututeServices.loadAll();
        System.out.println("All institutes: " + Arrays.toString(allInstitutes.toArray()));
        return new ResponseEntity<>(allInstitutes, HttpStatus.OK);
    }
}
