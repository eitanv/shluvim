package org.evolsw.shluvim.controller.rest;

import org.evolsw.shluvim.controller.services.InstututeServices;
import org.evolsw.shluvim.model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}/cost={cost}")
    public ResponseEntity<String> updateInstituteSalary(@PathVariable Long id, @PathVariable double cost) {
        Institute institute = instututeServices.load(id);
        institute.setBaseCost(cost);
        instututeServices.save(institute);
        System.out.println("Updated " + institute.getInstituteName() + "`s Cost to " + cost);
        return new ResponseEntity<>("Updated cost", HttpStatus.OK);
    }
}
