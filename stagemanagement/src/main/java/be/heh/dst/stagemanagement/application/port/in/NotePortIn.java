package be.heh.dst.stagemanagement.application.port.in;

import be.heh.dst.stagemanagement.application.domain.model.Note;
import java.util.List;

public interface NotePortIn {

    List<Note> getAllNotes();
    Note getNoteById(Integer idNote);
    Note addNote(Note note);
    void deleteNoteById(Integer idNote);
}
