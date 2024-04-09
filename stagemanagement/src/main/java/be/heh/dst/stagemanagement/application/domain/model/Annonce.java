package be.heh.dst.stagemanagement.application.domain.model;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Annonce {

    private Integer idAnnonce;
    private String description;
    private String nomContact;
    private String prenomContact;
    private String emailContact;
    private String telephoneContact;
    private String tagSection;
    private Timestamp date;
    private int idSociete;

    public Annonce(Integer idAnnonce, String description, String nomContact, String prenomContact, String emailContact, String telephoneContact, String tagSection, Timestamp date, int idSociete) {
        this.idAnnonce = idAnnonce;
        this.description = description;
        this.nomContact = nomContact;
        this.prenomContact = prenomContact;
        this.emailContact = emailContact;
        this.telephoneContact = telephoneContact;
        this.tagSection = tagSection;
        this.date = date;
        this.idSociete = idSociete;
    }
}
