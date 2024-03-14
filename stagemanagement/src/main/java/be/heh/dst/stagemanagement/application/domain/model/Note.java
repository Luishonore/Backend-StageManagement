package be.heh.dst.stagemanagement.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Note {

    private Integer idNote;
    private int accueil;
    private int charge;
    private int implication;
    private int lieu;
    private int idSociete;

    public Note(Integer idNote, int accueil, int charge, int implication, int lieu, int idSociete) {
        this.idNote = idNote;
        this.accueil = accueil;
        this.charge = charge;
        this.implication = implication;
        this.lieu = lieu;
        this.idSociete = idSociete;
    }
}