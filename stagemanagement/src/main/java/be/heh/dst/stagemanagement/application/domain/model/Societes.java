package be.heh.dst.stagemanagement.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Societes {

    private Long id;
    private String nom;
    private String telephone;

    public Societes(Long id, String nom, String telephone) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
    }

}
