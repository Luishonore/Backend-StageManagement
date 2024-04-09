package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import be.heh.dst.stagemanagement.application.port.out.SocietePortOut;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Log4j2
@Repository
public class SocieteRepository implements SocietePortOut {

    //LOG
    private static final Logger logger = LoggerFactory.getLogger(SocieteRepository.class);
    private final JdbcTemplate jdbcTemplate;
    public SocieteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Societe> findAll() {
        return jdbcTemplate.query("SELECT * FROM SOCIETE",
                (rs, rowNum) -> new Societe(
                        rs.getInt("ID_SOCIETE"),
                        rs.getString("NOM"),
                        rs.getString("N"),
                        rs.getString("RUE"),
                        rs.getString("CODE_POSTAL"),
                        rs.getString("VILLE"),
                        rs.getString("TELEPHONE"),
                        rs.getString("EMAIL"),
                        rs.getString("URL"),
                        rs.getString("ACTIVITE")
                )
        );
    }

    @Override
    public List<Societe> findByName(String nom) {
        return jdbcTemplate.query("SELECT * FROM SOCIETE WHERE NOM = ?",
                new Object[]{nom},
                (rs, rowNum) -> new Societe(
                        rs.getInt("ID_SOCIETE"),
                        rs.getString("NOM"),
                        rs.getString("N"),
                        rs.getString("RUE"),
                        rs.getString("CODE_POSTAL"),
                        rs.getString("VILLE"),
                        rs.getString("TELEPHONE"),
                        rs.getString("EMAIL"),
                        rs.getString("URL"),
                        rs.getString("ACTIVITE")
                )
        );
    }

    @Override
    public Societe save(Societe societe) {
        // Génération de l'ID
        Integer idSociete = jdbcTemplate.queryForObject("SELECT nextval('seq_id_societes')", Integer.class);
        societe.setIdSociete(idSociete);

        // Insertion de la société
        jdbcTemplate.update("INSERT INTO SOCIETE (ID_SOCIETE, NOM, N, RUE, CODE_POSTAL, VILLE, TELEPHONE, EMAIL, URL, ACTIVITE) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                societe.getIdSociete(),
                societe.getNom(),
                societe.getN(),
                societe.getRue(),
                societe.getCode_postal(),
                societe.getVille(),
                societe.getTelephone(),
                societe.getEmail(),
                societe.getUrl(),
                societe.getActivite()
        );

        // Log d'information
        logger.info("Société ajoutée avec succès: {}", String.format("ID: %d, Nom: %s, N°: %s, Rue: %s, Code postal: %s, Ville: %s, Téléphone: %s, E-mail: %s, URL: %s, Activité: %s",
                societe.getIdSociete(),
                societe.getNom(),
                societe.getN(),
                societe.getRue(),
                societe.getCode_postal(),
                societe.getVille(),
                societe.getTelephone(),
                societe.getEmail(),
                societe.getUrl(),
                societe.getActivite()
                )
        );
        return societe;
    }

    @Override
    public void deleteById(Integer idSociete) {
        jdbcTemplate.update("DELETE FROM SOCIETE WHERE id_societe = ?", idSociete);
        logger.info("Société supprimé avec succès - ID: {}", idSociete);
    }
}