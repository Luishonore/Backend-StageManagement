package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import be.heh.dst.stagemanagement.application.port.out.SocietePortOut;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SocieteRepository implements SocietePortOut {

    private final JdbcTemplate jdbcTemplate;
    public SocieteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Societe> findAll() {
        return jdbcTemplate.query("SELECT * FROM SOCIETES",
                (rs, rowNum) -> new Societe(
                        rs.getLong("ID_SOCIETES"),
                        rs.getString("NOM"),
                        rs.getString("TELEPHONE")
                )
        );
    }

    @Override
    public Societe findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM SOCIETES WHERE id_societes = ?",
                new Object[]{id},
                (rs, rowNum) -> new Societe(
                        rs.getLong("ID_SOCIETES"),
                        rs.getString("NOM"),
                        rs.getString("TELEPHONE")
                )
        );
    }

    @Override
    public Societe save(Societe societe) {
        jdbcTemplate.update("INSERT INTO SOCIETES (id_societes, NOM, TELEPHONE) VALUES (?, ?, ?)",
                societe.getId(), societe.getNom(), societe.getTelephone());
        return societe;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM SOCIETES WHERE id_societes = ?", id);
    }

}