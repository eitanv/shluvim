package org.evolsw.shluvim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "INSTITUTES")
@Data
public class Institute {

    @Id
    Long instituteId;
    String instituteName;
    String instituteType;
    double baseCost;

}
