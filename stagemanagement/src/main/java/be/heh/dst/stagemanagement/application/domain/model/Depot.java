package be.heh.dst.stagemanagement.application.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Setter
@Getter
public class Depot {

    private Integer idDepot;
    private String nomDepot;
    private String description;
    private Timestamp dateFermeture;

    public Depot(Integer idDepot, String nomDepot, String description, Timestamp dateFermeture){
        this.idDepot = idDepot;
        this.nomDepot = nomDepot;
        this.description = description;
        this.dateFermeture = dateFermeture;
    }
}
