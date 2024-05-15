package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.Annonce;
import be.heh.dst.stagemanagement.application.domain.model.Depot;
import be.heh.dst.stagemanagement.application.port.out.DepotPortOut;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Log4j2
@Repository
class DepotRepository implements DepotPortOut {
    //LOG
    private static final Logger logger = LoggerFactory.getLogger(DepotRepository.class);

    private final JdbcTemplate jdbcTemplate;

    public DepotRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Depot> findAll() {
        return jdbcTemplate.query("SELECT * FROM DEPOT",
                (rs, rowNum) -> new Depot(
                        rs.getInt("ID_DEPOT"),
                        rs.getString("NOM_DEPOT"),
                        rs.getString("DESCRIPTION"),
                        rs.getTimestamp("DATE_FERMETURE")
                )
        );
    }

    @Override
    public Depot findById(Integer idDepot) {
        return jdbcTemplate.queryForObject("SELECT * FROM DEPOT WHERE ID_DEPOT = ?",
                new Object[]{idDepot},
                (rs, rowNum) -> new Depot(
                        rs.getInt("ID_DEPOT"),
                        rs.getString("NOM_DEPOT"),
                        rs.getString("DESCRIPTION"),
                        rs.getTimestamp("DATE_FERMETURE")
                )
        );
    }

    @Override
    public Depot save(Depot depot) {
        // Génération de l'ID
        Integer idDepot = jdbcTemplate.queryForObject("SELECT nextval('seq_id_depot')", Integer.class);
        depot.setIdDepot(idDepot);

        // Insertion de l'annonce
        jdbcTemplate.update("INSERT INTO DEPOT (ID_DEPOT, NOM_DEPOT, DESCRIPTION, DATE_FERMETURE) " + "VALUES (?, ?, ?, ?)",
                depot.getIdDepot(),
                depot.getNomDepot(),
                depot.getDescription(),
                depot.getDateFermeture()
        );
        // Log d'information
        logger.info("Zone de dépôt ajouter avec succès: {}",
                String.format("ID: %d, Nom du dépôt: %s, Description: %s, Date de fermeture : %s ",
                        depot.getIdDepot(),
                        depot.getNomDepot(),
                        depot.getDescription(),
                        depot.getDateFermeture()
                )
        );
        return depot;
    }

    @Override
    public void deleteById(Integer idDepot) {
        jdbcTemplate.update("DELETE FROM DEPOT WHERE ID_DEPOT = ?", idDepot);
        logger.info("Zone de dépôt supprimé avec succès - ID: {}", idDepot);
    }
}
