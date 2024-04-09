package be.heh.dst.stagemanagement.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Societe {

    private Integer idSociete;
    private String nom;
    private String n;
    private String rue;
    private String code_postal;
    private String ville;
    private String telephone;
    private String email;
    private String url;
    private String activite;

    public Societe(Integer idSociete, String nom, String n, String rue, String code_postal, String ville, String telephone, String email, String url, String activite) {
        this.idSociete = idSociete;
        this.nom = nom;
        this.n = n;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
        this.telephone = telephone;
        this.email = email;
        this.url = url;
        this.activite = activite;
    }
}