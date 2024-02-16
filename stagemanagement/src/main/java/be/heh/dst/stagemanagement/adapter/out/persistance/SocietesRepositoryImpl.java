package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.Societes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SocietesRepositoryImpl implements SocietesRepository {

    private final JdbcTemplate jdbcTemplate;

    public SocietesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Societes> findAll() {
        return jdbcTemplate.query("SELECT * FROM SOCIETES",
                (rs, rowNum) -> new Societes(
                        rs.getLong("ID_SOCIETES"),
                        rs.getString("NOM"),
                        rs.getString("TELEPHONE")
                )
        );
    }

    @Override
    public Societes findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM SOCIETES WHERE id_societes = ?",
                new Object[]{id},
                (rs, rowNum) -> new Societes(
                        rs.getLong("ID_SOCIETES"),
                        rs.getString("NOM"),
                        rs.getString("TELEPHONE")
                )
        );
    }

    @Override
    public Societes save(Societes societe) {
        jdbcTemplate.update("INSERT INTO SOCIETES (id_societes, NOM, TELEPHONE) VALUES (?, ?, ?)",
                societe.getId(), societe.getNom(), societe.getTelephone());
        return societe;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM SOCIETES WHERE id_societes = ?", id);
    }

}