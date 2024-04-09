package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.Annonce;
import be.heh.dst.stagemanagement.application.port.out.AnnoncePortOut;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Log4j2
@Repository
public class AnnonceRepository implements AnnoncePortOut {

    //LOG
    private static final Logger logger = LoggerFactory.getLogger(AnnonceRepository.class);

    private final JdbcTemplate jdbcTemplate;

    public AnnonceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Annonce> findAll() {
        return jdbcTemplate.query("SELECT * FROM ANNONCE",
                (rs, rowNum) -> new Annonce(
                        rs.getInt("ID_ANNONCE"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("NOM_CONTACT"),
                        rs.getString("PRENOM_CONTACT"),
                        rs.getString("EMAIL_CONTACT"),
                        rs.getString("TELEPHONE_CONTACT"),
                        rs.getString("TAG_SECTION"),
                        rs.getTimestamp("DATE"),
                        rs.getInt("ID_SOCIETE")
                )
        );
    }

    @Override
    public Annonce findById(Integer idAnnonce) {
        return jdbcTemplate.queryForObject("SELECT * FROM ANNONCE WHERE ID_ANNONCE = ?",
                new Object[]{idAnnonce},
                (rs, rowNum) -> new Annonce(
                        rs.getInt("ID_ANNONCE"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("NOM_CONTACT"),
                        rs.getString("PRENOM_CONTACT"),
                        rs.getString("EMAIL_CONTACT"),
                        rs.getString("TELEPHONE_CONTACT"),
                        rs.getString("TAG_SECTION"),
                        rs.getTimestamp("DATE"),
                        rs.getInt("ID_SOCIETE")
                )
        );
    }

    @Override
    public Annonce save(Annonce annonce) {
        // Génération de l'ID
        Integer idAnnonce = jdbcTemplate.queryForObject("SELECT nextval('seq_id_annonces')", Integer.class);
        annonce.setIdAnnonce(idAnnonce);

        // Insertion de l'annonce
        jdbcTemplate.update("INSERT INTO ANNONCE (ID_ANNONCE, DESCRIPTION, NOM_CONTACT, PRENOM_CONTACT, EMAIL_CONTACT, " +
                        "TELEPHONE_CONTACT, TAG_SECTION, ID_SOCIETE) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                annonce.getIdAnnonce(),
                annonce.getDescription(),
                annonce.getNomContact(),
                annonce.getPrenomContact(),
                annonce.getEmailContact(),
                annonce.getTelephoneContact(),
                annonce.getTagSection(),
                annonce.getIdSociete()
        );
        // Log d'information
        logger.info("Annonce ajouter avec succès: {}",
                String.format("ID: %d, Description: %s, Nom du contact: %s, Prénom du contact: %s, Email du contact: %s, Téléphone du contact: %s, Tag: %s, ID-Société: %d",
                        annonce.getIdAnnonce(),
                        annonce.getDescription(),
                        annonce.getNomContact(),
                        annonce.getPrenomContact(),
                        annonce.getEmailContact(),
                        annonce.getTelephoneContact(),
                        annonce.getTagSection(),
                        annonce.getIdSociete()
                )
        );
        return annonce;
    }

    @Override
    public void deleteById(Integer idAnnonce) {
        jdbcTemplate.update("DELETE FROM ANNONCE WHERE ID_ANNONCE = ?", idAnnonce);
        logger.info("Société supprimé avec succès - ID: {}", idAnnonce);
    }
}