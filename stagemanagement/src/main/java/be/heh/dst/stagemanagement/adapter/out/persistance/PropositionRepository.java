package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.Proposition;
import be.heh.dst.stagemanagement.application.port.out.PropositionPortOut;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Log4j2
@Repository
class PropositionRepository implements PropositionPortOut {

    //LOG
    private static final Logger logger = LoggerFactory.getLogger(PropositionRepository.class);

    private final JdbcTemplate jdbcTemplate;

    public PropositionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Table PROPOSITION_NON_VALIDER
    @Override
    public List<Proposition> findAll() {
        return jdbcTemplate.query("SELECT * FROM PROPOSITION_NON_VALIDER",
                (rs, rowNum) -> new Proposition(
                        rs.getInt("ID_PROPOSITION"),
                        rs.getString("OBJECTIF_STAGE"),
                        rs.getString("TELETRAVAIL"),
                        rs.getString("QUADRIMESTRE"),
                        rs.getString("ANNEE"),
                        rs.getString("NOM_ETUDIANT"),
                        rs.getString("PRENOM_ETUDIANT"),
                        rs.getString("EMAIL_ETUDIANT"),
                        rs.getString("TELEPHONE_ETUDIANT"),
                        rs.getString("N_NATIONAL_ETUDIANT"),
                        rs.getString("RUE_OFFI"),
                        rs.getString("N_OFFI"),
                        rs.getString("CODE_POSTAL_OFFI"),
                        rs.getString("VILLE_OFFI"),
                        rs.getString("RUE_STAGE"),
                        rs.getString("N_STAGE"),
                        rs.getString("CODE_POSTAL_STAGE"),
                        rs.getString("VILLE_STAGE"),
                        rs.getString("ENTREPRISE"),
                        rs.getString("RUE"),
                        rs.getString("N"),
                        rs.getString("CODE_POSTAL"),
                        rs.getString("VILLE"),
                        rs.getString("TELEPHONE"),
                        rs.getString("CHEF_PERSONNEL"),
                        rs.getString("EMAIL_CHEF"),
                        rs.getString("TELEPHONE_CHEF"),
                        rs.getString("MAITRE_DE_STAGE"),
                        rs.getString("EMAIL_MAITRE"),
                        rs.getString("TELEPHONE_MAITRE"),
                        rs.getString("VALIDATION_SECRETARIAT"),
                        rs.getString("VALIDATION_COORDINATEUR")
                )
        );
    }

    @Override
    public Proposition findById(Integer id_proposition) {
        return jdbcTemplate.queryForObject("SELECT * FROM PROPOSITION_NON_VALIDER WHERE ID_PROPOSITION = ?",
                new Object[]{id_proposition},
                (rs, rowNum) -> new Proposition(
                        rs.getInt("ID_PROPOSITION"),
                        rs.getString("OBJECTIF_STAGE"),
                        rs.getString("TELETRAVAIL"),
                        rs.getString("QUADRIMESTRE"),
                        rs.getString("ANNEE"),
                        rs.getString("NOM_ETUDIANT"),
                        rs.getString("PRENOM_ETUDIANT"),
                        rs.getString("EMAIL_ETUDIANT"),
                        rs.getString("TELEPHONE_ETUDIANT"),
                        rs.getString("N_NATIONAL_ETUDIANT"),
                        rs.getString("RUE_OFFI"),
                        rs.getString("N_OFFI"),
                        rs.getString("CODE_POSTAL_OFFI"),
                        rs.getString("VILLE_OFFI"),
                        rs.getString("RUE_STAGE"),
                        rs.getString("N_STAGE"),
                        rs.getString("CODE_POSTAL_STAGE"),
                        rs.getString("VILLE_STAGE"),
                        rs.getString("ENTREPRISE"),
                        rs.getString("RUE"),
                        rs.getString("N"),
                        rs.getString("CODE_POSTAL"),
                        rs.getString("VILLE"),
                        rs.getString("TELEPHONE"),
                        rs.getString("CHEF_PERSONNEL"),
                        rs.getString("EMAIL_CHEF"),
                        rs.getString("TELEPHONE_CHEF"),
                        rs.getString("MAITRE_DE_STAGE"),
                        rs.getString("EMAIL_MAITRE"),
                        rs.getString("TELEPHONE_MAITRE"),
                        rs.getString("VALIDATION_SECRETARIAT"),
                        rs.getString("VALIDATION_COORDINATEUR")
                )
        );
    }

    @Override
    public Proposition save(Proposition proposition) {
        // Génération de l'ID
        Integer id_proposition = jdbcTemplate.queryForObject("SELECT nextval('seq_id_proposition_stage')", Integer.class);
        proposition.setId_proposition(id_proposition);

        // Insertion de la proposition
        jdbcTemplate.update("INSERT INTO PROPOSITION_NON_VALIDER (ID_PROPOSITION, OBJECTIF_STAGE, TELETRAVAIL, QUADRIMESTRE, ANNEE, " +
                        "NOM_ETUDIANT, PRENOM_ETUDIANT, EMAIL_ETUDIANT, TELEPHONE_ETUDIANT, N_NATIONAL_ETUDIANT, " +
                        "RUE_OFFI, N_OFFI, CODE_POSTAL_OFFI, VILLE_OFFI, " +
                        "RUE_STAGE, N_STAGE, CODE_POSTAL_STAGE, VILLE_STAGE, " +
                        "ENTREPRISE, RUE, N, CODE_POSTAL, VILLE, TELEPHONE, " +
                        "CHEF_PERSONNEL, EMAIL_CHEF, TELEPHONE_CHEF, MAITRE_DE_STAGE, EMAIL_MAITRE, TELEPHONE_MAITRE) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                proposition.getId_proposition(),
                proposition.getObjectifStage(),
                proposition.getTeletravail(),
                proposition.getQuadrimestre(),
                proposition.getAnnee(),
                proposition.getNomEtudiant(),
                proposition.getPrenomEtudiant(),
                proposition.getEmailEtudiant(),
                proposition.getTelephoneEtudiant(),
                proposition.getNNationalEtudiant(),
                proposition.getRueOffi(),
                proposition.getNOffi(),
                proposition.getCodePostalOffi(),
                proposition.getVilleOffi(),
                proposition.getRueStage(),
                proposition.getNStage(),
                proposition.getCodePostalStage(),
                proposition.getVilleStage(),
                proposition.getEntreprise(),
                proposition.getRue(),
                proposition.getN(),
                proposition.getCodePostal(),
                proposition.getVille(),
                proposition.getTelephone(),
                proposition.getChefPersonnel(),
                proposition.getEmailChef(),
                proposition.getTelephoneChef(),
                proposition.getMaitreDeStage(),
                proposition.getEmailMaitre(),
                proposition.getTelephoneMaitre()
        );
        // Log d'information
        logger.info("Proposition ajoutée avec succès: {}",
                String.format("ID: %d, Objectif de stage: %s, etc...",
                        proposition.getId_proposition(),
                        proposition.getObjectifStage()
                )
        );
        return proposition;
    }

    @Override
    public void deleteById(Integer id_proposition) {
        jdbcTemplate.update("DELETE FROM PROPOSITION_NON_VALIDER WHERE ID_PROPOSITION = ?", id_proposition);
        logger.info("Proposition supprimé avec succès - ID: {}", id_proposition);
    }

    // Validation des proposition
    @Override
    public void patchValidationSecretariat(Integer id_proposition, String newValue) {
        jdbcTemplate.update("UPDATE PROPOSITION_NON_VALIDER SET VALIDATION_SECRETARIAT = ? WHERE ID_PROPOSITION = ?",
                newValue, id_proposition);
        logger.info("Validation Secretariat modifiée avec succès pour la proposition avec l'ID: {}", id_proposition);
    }

    @Override
    public void patchValidationCoordinateur(Integer id_proposition, String newValue) {
        jdbcTemplate.update("UPDATE PROPOSITION_NON_VALIDER SET VALIDATION_COORDINATEUR = ? WHERE ID_PROPOSITION = ?",
                newValue, id_proposition);
        logger.info("Validation Coordinateur modifiée avec succès pour la proposition avec l'ID: {}", id_proposition);
    }

}