package be.heh.dst.stagemanagement.application.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proposition {
    private int id_proposition;
    private String objectifStage;
    private String teletravail;
    private String quadrimestre;
    private String annee;

    private String nomEtudiant;
    private String prenomEtudiant;
    private String emailEtudiant;
    private String telephoneEtudiant;
    private String nNationalEtudiant;

    private String rueOffi;
    private String nOffi;
    private String codePostalOffi;
    private String villeOffi;

    private String rueStage;
    private String nStage;
    private String codePostalStage;
    private String villeStage;

    private String entreprise;
    private String rue;
    private String n;
    private String codePostal;
    private String ville;
    private String telephone;

    private String chefPersonnel;
    private String emailChef;
    private String telephoneChef;

    private String maitreDeStage;
    private String emailMaitre;
    private String telephoneMaitre;

    private String validationSecretariat;
    private String validationCoordinateur;

    public Proposition(int id_proposition, String objectifStage, String teletravail, String quadrimestre, String annee, String nomEtudiant, String prenomEtudiant,
                       String emailEtudiant, String telephoneEtudiant, String nNationalEtudiant, String rueOffi, String nOffi,
                       String codePostalOffi, String villeOffi, String rueStage, String nStage, String codePostalStage,
                       String villeStage, String entreprise, String rue, String n, String codePostal, String ville,
                       String telephone, String chefPersonnel, String emailChef, String telephoneChef, String maitreDeStage,
                       String emailMaitre, String telephoneMaitre, String validationSecretariat, String validationCoordinateur) {
        this.id_proposition = id_proposition;
        this.objectifStage = objectifStage;
        this.teletravail = teletravail;
        this.quadrimestre = quadrimestre;
        this.annee = annee;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.emailEtudiant = emailEtudiant;
        this.telephoneEtudiant = telephoneEtudiant;
        this.nNationalEtudiant = nNationalEtudiant;
        this.rueOffi = rueOffi;
        this.nOffi = nOffi;
        this.codePostalOffi = codePostalOffi;
        this.villeOffi = villeOffi;
        this.rueStage = rueStage;
        this.nStage = nStage;
        this.codePostalStage = codePostalStage;
        this.villeStage = villeStage;
        this.entreprise = entreprise;
        this.rue = rue;
        this.n = n;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.chefPersonnel = chefPersonnel;
        this.emailChef = emailChef;
        this.telephoneChef = telephoneChef;
        this.maitreDeStage = maitreDeStage;
        this.emailMaitre = emailMaitre;
        this.telephoneMaitre = telephoneMaitre;
        this.validationSecretariat = validationSecretariat;
        this.validationCoordinateur = validationCoordinateur;
    }
}
