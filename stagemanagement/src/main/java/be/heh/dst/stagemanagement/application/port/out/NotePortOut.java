package be.heh.dst.stagemanagement.application.port.out;

import be.heh.dst.stagemanagement.application.domain.model.Note;
import java.util.List;

public interface NotePortOut {
    List<Note> findAll();
    Note findById(Integer idNote);
    Note save(Note note);
    void deleteById(Integer idNote);
}
