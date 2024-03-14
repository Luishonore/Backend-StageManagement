package be.heh.dst.stagemanagement.application.port.out;

import be.heh.dst.stagemanagement.application.domain.model.Note;

import java.util.List;

public interface NotePortOut {
    Note save(Note note);

    List<Note> findAll();

    Note findById(Integer idNote);

    void deleteById(Integer idNote);
}
