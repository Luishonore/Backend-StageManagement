CREATE SEQUENCE seq_id_societes START 1 INCREMENT 1;
CREATE TABLE SOCIETE
(
    ID_SOCIETE  int PRIMARY KEY DEFAULT NEXTVAL('seq_id_societes'),
    NOM         varchar(255) NOT NULL,
    N           varchar(5),
    RUE         varchar(255),
    CODE_POSTAL varchar(6),
    VILLE       varchar(255),
    TELEPHONE   varchar(255),
    EMAIL       varchar(255),
    URL         varchar(255),
    ACTIVITE    varchar(255)
);

CREATE SEQUENCE seq_id_notes START 1 INCREMENT 1;
CREATE TABLE NOTE
(
    ID_NOTE     int PRIMARY KEY DEFAULT NEXTVAL('seq_id_notes'),
    ACCUEIL     int NOT NULL,
    CHARGE      int NOT NULL,
    IMPLICATION int NOT NULL,
    LIEU        int NOT NULL,

    ID_SOCIETE  int NOT NULL,
    FOREIGN KEY (id_societe) REFERENCES SOCIETE (ID_SOCIETE)
);

CREATE SEQUENCE seq_id_annonces START 1 INCREMENT 1;
CREATE TABLE ANNONCE (
    ID_ANNONCE          int PRIMARY KEY DEFAULT NEXTVAL('seq_id_annonces'),
    DESCRIPTION         varchar(255) NOT NULL ,
    NOM_CONTACT         varchar(255),
    PRENOM_CONTACT      varchar(255),
    EMAIL_CONTACT       varchar(255),
    TELEPHONE_CONTACT   varchar(255),
    TAG_SECTION         varchar(255),
    DATE                TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    ID_SOCIETE  int NOT NULL,
    FOREIGN KEY (id_societe) REFERENCES SOCIETE (ID_SOCIETE)
);

/* Fiche: proposition de stage */
CREATE SEQUENCE seq_id_proposition_stage START 1 INCREMENT 1;
CREATE TABLE PROPOSITION_NON_VALIDER (
    ID_PROPOSITION          int PRIMARY KEY DEFAULT NEXTVAL('seq_id_proposition_stage'),
    OBJECTIF_STAGE          varchar(255) NOT NULL,
    TELETRAVAIL             varchar(10) NOT NULL,
    QUADRIMESTRE            varchar(10) NOT NULL,
    ANNEE                   varchar(10) NOT NULL,
    /* ETUDIANT */
    NOM_ETUDIANT            varchar(255) NOT NULL,
    PRENOM_ETUDIANT         varchar(255) NOT NULL,
    EMAIL_ETUDIANT          varchar(255) NOT NULL,
    TELEPHONE_ETUDIANT      varchar(255) NOT NULL,
    N_NATIONAL_ETUDIANT     varchar(255) NOT NULL,
    /* ADRESSE OFFICIEL ETUDIANT */
    RUE_OFFI                varchar(255) NOT NULL,
    N_OFFI                  varchar(5) NOT NULL,
    CODE_POSTAL_OFFI        varchar(6) NOT NULL,
    VILLE_OFFI              varchar(255) NOT NULL,
    /* ADRESSE PENDANT STAGE */
    RUE_STAGE               varchar(255) NOT NULL,
    N_STAGE                 varchar(5) NOT NULL,
    CODE_POSTAL_STAGE       varchar(6) NOT NULL,
    VILLE_STAGE             varchar(255) NOT NULL,
    /* COORDONEES STAGE */
    ENTREPRISE              varchar(255) NOT NULL,
    RUE                     varchar(255) NOT NULL,
    N                       varchar(5) NOT NULL,
    CODE_POSTAL             varchar(6) NOT NULL,
    VILLE                   varchar(255) NOT NULL,
    TELEPHONE               varchar(255) NOT NULL,
    /* CONTACT */
    CHEF_PERSONNEL          varchar(255) NOT NULL,
    EMAIL_CHEF              varchar(255) NOT NULL,
    TELEPHONE_CHEF          varchar(255) NOT NULL,
    MAITRE_DE_STAGE         varchar(255) NOT NULL,
    EMAIL_MAITRE            varchar(255) NOT NULL,
    TELEPHONE_MAITRE        varchar(255) NOT NULL,
    /* VALIDATION */
    VALIDATION_SECRETARIAT  varchar(20) DEFAULT 'en attente',
    VALIDATION_COORDINATEUR varchar(20) DEFAULT 'en attente'
);

CREATE TABLE PROPOSITION_VALIDER (
    ID_PROPOSITION          INTEGER PRIMARY KEY,
    OBJECTIF_STAGE          varchar(255) NOT NULL,
    TELETRAVAIL             varchar(10) NOT NULL,
    QUADRIMESTRE            varchar(10) NOT NULL,
    ANNEE                   varchar(10) NOT NULL,
    /* ETUDIANT */
    NOM_ETUDIANT            varchar(255) NOT NULL,
    PRENOM_ETUDIANT         varchar(255) NOT NULL,
    EMAIL_ETUDIANT          varchar(255) NOT NULL,
    TELEPHONE_ETUDIANT      varchar(255) NOT NULL,
    N_NATIONAL_ETUDIANT     varchar(255) NOT NULL,
    /* ADRESSE OFFICIEL ETUDIANT */
    RUE_OFFI                varchar(255) NOT NULL,
    N_OFFI                  varchar(5) NOT NULL,
    CODE_POSTAL_OFFI        varchar(6) NOT NULL,
    VILLE_OFFI              varchar(255) NOT NULL,
    /* ADRESSE PENDANT STAGE */
    RUE_STAGE               varchar(255) NOT NULL,
    N_STAGE                 varchar(5) NOT NULL,
    CODE_POSTAL_STAGE       varchar(6) NOT NULL,
    VILLE_STAGE             varchar(255) NOT NULL,
    /* COORDONEES STAGE */
    ENTREPRISE              varchar(255) NOT NULL,
    RUE                     varchar(255) NOT NULL,
    N                       varchar(5) NOT NULL,
    CODE_POSTAL             varchar(6) NOT NULL,
    VILLE                   varchar(255) NOT NULL,
    TELEPHONE               varchar(255) NOT NULL,
    /* CONTACT */
    CHEF_PERSONNEL          varchar(255) NOT NULL,
    EMAIL_CHEF              varchar(255) NOT NULL,
    TELEPHONE_CHEF          varchar(255) NOT NULL,
    MAITRE_DE_STAGE         varchar(255) NOT NULL,
    EMAIL_MAITRE            varchar(255) NOT NULL,
    TELEPHONE_MAITRE        varchar(255) NOT NULL
);

-- Trigger pour valider une proposition
CREATE OR REPLACE FUNCTION valider_proposition()
    RETURNS TRIGGER AS $$
BEGIN
    -- Vérifier si les deux statuts de validation sont "validé"
    IF NEW.VALIDATION_SECRETARIAT = 'validé' AND NEW.VALIDATION_COORDINATEUR = 'validé' THEN
        -- Insérer la proposition validée dans la table PROPOSITION_VALIDE
        INSERT INTO PROPOSITION_VALIDER (ID_PROPOSITION, OBJECTIF_STAGE, TELETRAVAIL, QUADRIMESTRE, ANNEE, NOM_ETUDIANT, PRENOM_ETUDIANT, EMAIL_ETUDIANT, TELEPHONE_ETUDIANT, N_NATIONAL_ETUDIANT,
                                        RUE_OFFI, N_OFFI, CODE_POSTAL_OFFI, VILLE_OFFI, RUE_STAGE, N_STAGE, CODE_POSTAL_STAGE, VILLE_STAGE,
                                        ENTREPRISE, RUE, N, CODE_POSTAL, VILLE, TELEPHONE,
                                        CHEF_PERSONNEL, EMAIL_CHEF, TELEPHONE_CHEF, MAITRE_DE_STAGE, EMAIL_MAITRE, TELEPHONE_MAITRE)
        SELECT NEW.ID_PROPOSITION, NEW.OBJECTIF_STAGE, NEW.TELETRAVAIL, NEW.QUADRIMESTRE, NEW.ANNEE, NEW.NOM_ETUDIANT, NEW.PRENOM_ETUDIANT, NEW.EMAIL_ETUDIANT, NEW.TELEPHONE_ETUDIANT, NEW.N_NATIONAL_ETUDIANT,
               NEW.RUE_OFFI, NEW.N_OFFI, NEW.CODE_POSTAL_OFFI, NEW.VILLE_OFFI, NEW.RUE_STAGE, NEW.N_STAGE, NEW.CODE_POSTAL_STAGE, NEW.VILLE_STAGE,
               NEW.ENTREPRISE, NEW.RUE, NEW.N, NEW.CODE_POSTAL, NEW.VILLE, NEW.TELEPHONE,
               NEW.CHEF_PERSONNEL, NEW.EMAIL_CHEF, NEW.TELEPHONE_CHEF, NEW.MAITRE_DE_STAGE, NEW.EMAIL_MAITRE, NEW.TELEPHONE_MAITRE
        WHERE NOT EXISTS (
            SELECT 1 FROM PROPOSITION_VALIDER WHERE ID_PROPOSITION = NEW.ID_PROPOSITION
        );

        -- Supprimer la proposition de la table PROPOSITION_NON_VALIDER
        DELETE FROM PROPOSITION_NON_VALIDER WHERE ID_PROPOSITION = NEW.ID_PROPOSITION;
    END IF;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

-- Création du déclencheur après mise à jour de la table PROPOSITION_NON_VALIDER
CREATE TRIGGER proposition_validee_trigger
    AFTER UPDATE ON PROPOSITION_NON_VALIDER
    FOR EACH ROW
EXECUTE FUNCTION valider_proposition();



/* ************************* */
/* TABLE EN COURS D'ECRITURE */
/* ************************* */



/* Fiche: titre de stage */
CREATE SEQUENCE seq_id_fiche_titre_stage START 1 INCREMENT 1;
CREATE TABLE FICHE_TITRE_STAGE (
    ID_TITRE_STAGE          int PRIMARY KEY DEFAULT NEXTVAL('seq_id_fiche_titre_stage'),
    /* ETUDIANT */
    NOM_ETUDIANT            varchar(255) NOT NULL,
    PRENOM_ETUDIANT         varchar(255) NOT NULL,
    RUE_ETUDIANT            varchar(255) NOT NULL,
    N_ETUDIANT              varchar(5) NOT NULL,
    CODE_POSTAL_ETUDIANT    varchar(6) NOT NULL,
    VILLE_ETUDIANT          varchar(255) NOT NULL,
    TELEPHONE_ETUDIANT      varchar(255) NOT NULL,
    EMAIL_ETUDIANT          varchar(255) NOT NULL,
    /* ENTREPRISE */
    ENTREPRISE              varchar(255) NOT NULL,
    RUE                     varchar(255) NOT NULL,
    N                       varchar(5) NOT NULL,
    CODE_POSTAL             varchar(6) NOT NULL,
    VILLE                   varchar(255) NOT NULL,
    /* PROMOTEUR DU STAGE */
    PROMOTEUR               varchar(255) NOT NULL,
    EMAIL_PROMOTEUR         varchar(255) NOT NULL,
    TELEPHONE_PROMOTEUR     varchar(255) NOT NULL,
    SUJET_STAGE             varchar(255) NOT NULL,
    TITRE_STAGE             varchar(255) NOT NULL,
    /* PROFFESEUR RESPONSABLE DU STAGE (à ne pas remplir par l'étudiant) */
    NOM_PROF                varchar(255),
    EMAIL_PROF              varchar(255)
);




/* ZONE DE DEPOT */
CREATE SEQUENCE seq_id_depot START 1 INCREMENT 1;
CREATE TABLE DEPOT (
    ID_DEPOT                int PRIMARY KEY DEFAULT NEXTVAL('seq_id_depot'),
    NOM_DEPOT               varchar(255) NOT NULL,
    DESCRIPTION             varchar(255),
    DATE_FERMETURE          timestamp
);
/* DOCUMENT PDF */
CREATE SEQUENCE seq_id_doc_depot_pdf START 1 INCREMENT 1;
CREATE TABLE DOC_DEPOT_PDF (
    ID_DOC_DEPOT_PDF        int PRIMARY KEY DEFAULT NEXTVAL('seq_id_doc_depot_pdf'),
    DOCUMENT                bytea NOT NULL,

    ID_DEPOT int NOT NULL,
    FOREIGN KEY (ID_DEPOT) REFERENCES DEPOT (ID_DEPOT)
);
/* DOCUMENT TEXT */
CREATE SEQUENCE seq_id_doc_depot_txt START 1 INCREMENT 1;
CREATE TABLE DOC_DEPOT_TXT (
    ID_DOC_DEPOT_TXT        int PRIMARY KEY DEFAULT NEXTVAL('seq_id_doc_depot_txt'),
    DOCUMENT                varchar(1020) NOT NULL,

    ID_DEPOT int NOT NULL,
    FOREIGN KEY (ID_DEPOT) REFERENCES DEPOT (ID_DEPOT)
);