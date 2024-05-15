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

/* ************************* */
/* TABLE EN COURS D'ECRITURE */
/* ************************* */

/* Fiche: proposition de stage */
CREATE SEQUENCE seq_id_proposition_stage START 1 INCREMENT 1;
CREATE TABLE PROPOSITION_STAGE (
    ID_PROPOSITION_STAGE    int PRIMARY KEY DEFAULT NEXTVAL('seq_id_proposition_stage'),
    /* ETUDIANT */
    NOM_ETUDIANT            varchar(255) NOT NULL,
    PRENOM_ETUDIANT         varchar(255) NOT NULL,
    TELEPHONE_ETUDIANT      varchar(255) NOT NULL,
    N_NATIONAL_ETUDIANT     varchar(255) NOT NULL,
    EMAIL_ETUDIANT          varchar(255) NOT NULL,
    /* ADRESSE OFFICIEL ETUDIANT */
    RUE_OFFI                varchar(255) NOT NULL,
    N_OFFI                  varchar(5) NOT NULL,
    CODE_POSTAL_OFFI        varchar(6) NOT NULL,
    VILLE_OFFI              varchar(255) NOT NULL,
    /* ADRESSE PENDANT STAGE */
    RUE_STAGIAIRE           varchar(255) NOT NULL,
    N_STAGIAIRE             varchar(5) NOT NULL,
    CODE_POSTAL_STAGIAIRE   varchar(6) NOT NULL,
    VILLE_STAGIAIRE         varchar(255) NOT NULL,
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
    /* AUTRE */
    OBJECTIF_STAGE          varchar(255) NOT NULL,
    TELETRAVAIL             varchar(10) NOT NULL,
    QUADRIMESTRE            varchar(10) NOT NULL,
    ANNEE                   int NOT NULL
);

/* Fiche: titre de stage */
CREATE SEQUENCE seq_id_titre_stage START 1 INCREMENT 1;
CREATE TABLE TITRE_STAGE (
    ID_TITRE_STAGE          int PRIMARY KEY DEFAULT NEXTVAL('seq_id_titre_stage'),
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