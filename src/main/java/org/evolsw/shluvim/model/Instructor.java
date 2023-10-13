package org.evolsw.shluvim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "INSTRUCTORS")
@Data
public class Instructor {

    @Id
    Long instructorId;
    String name;
    double hourSalary;

}
