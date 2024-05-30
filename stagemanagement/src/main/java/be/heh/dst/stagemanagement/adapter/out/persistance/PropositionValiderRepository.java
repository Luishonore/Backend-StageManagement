package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.PropositionValider;
import be.heh.dst.stagemanagement.application.port.out.PropositionValiderPortOut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
class PropositionValiderRepository implements PropositionValiderPortOut {

    private final JdbcTemplate jdbcTemplate;

    public PropositionValiderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PropositionValider> findAllValidated() {
        return jdbcTemplate.query("SELECT * FROM PROPOSITION_VALIDER",
                (rs, rowNum) -> new PropositionValider(
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
                        rs.getString("TELEPHONE_MAITRE")
                )
        );
    }

    @Override
    public PropositionValider findValidatedById(Integer id_proposition) {
        return jdbcTemplate.queryForObject("SELECT * FROM PROPOSITION_VALIDER WHERE ID_PROPOSITION = ?",
                new Object[]{id_proposition},
                (rs, rowNum) -> new PropositionValider(
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
                        rs.getString("TELEPHONE_MAITRE")
                )
        );
    }
}
