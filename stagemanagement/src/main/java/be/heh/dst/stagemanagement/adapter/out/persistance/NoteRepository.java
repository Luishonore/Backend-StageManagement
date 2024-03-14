package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.Note;
import be.heh.dst.stagemanagement.application.port.out.NotePortOut;

import lombok.extern.log4j.Log4j2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Log4j2
@Repository
public class NoteRepository implements NotePortOut {

    private final JdbcTemplate jdbcTemplate;

    public NoteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Note> findAll() {
        return jdbcTemplate.query("SELECT * FROM NOTE",
                (rs, rowNum) -> new Note(
                        rs.getInt("ID_NOTE"),
                        rs.getInt("ACCUEIL"),
                        rs.getInt("CHARGE"),
                        rs.getInt("IMPLICATION"),
                        rs.getInt("LIEU"),
                        rs.getInt("ID_SOCIETE")
                )
        );
    }

    @Override
    public Note findById(Integer idNote) {
        return jdbcTemplate.queryForObject("SELECT * FROM NOTE WHERE ID_NOTE = ?",
                new Object[]{idNote},
                (rs, rowNum) -> new Note(
                        rs.getInt("ID_NOTE"),
                        rs.getInt("ACCUEIL"),
                        rs.getInt("CHARGE"),
                        rs.getInt("IMPLICATION"),
                        rs.getInt("LIEU"),
                        rs.getInt("ID_SOCIETE")
                )
        );
    }

    @Override
    public Note save(Note note) {
        // Génération de l'ID
        Integer idNote = jdbcTemplate.queryForObject("SELECT nextval('seq_id_notes')", Integer.class);
        note.setIdNote(idNote);

        // Insertion de la note
        jdbcTemplate.update("INSERT INTO NOTE (ID_NOTE, ACCUEIL, CHARGE, IMPLICATION, LIEU, ID_SOCIETE) "
                        + "VALUES (?, ?, ?, ?, ?, ?)",
                note.getIdNote(),
                note.getAccueil(),
                note.getCharge(),
                note.getImplication(),
                note.getLieu(),
                note.getIdSociete()
        );
        return note;
    }

    @Override
    public void deleteById(Integer idNote) {
        jdbcTemplate.update("DELETE FROM NOTE WHERE ID_NOTE = ?", idNote);
    }
}
