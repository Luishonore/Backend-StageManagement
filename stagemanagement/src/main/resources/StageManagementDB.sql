CREATE SEQUENCE seq_id_societes START 1 INCREMENT 1;
CREATE SEQUENCE seq_id_notes START 1 INCREMENT 1;
CREATE SEQUENCE seq_id_annonces START 1 INCREMENT 1;

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