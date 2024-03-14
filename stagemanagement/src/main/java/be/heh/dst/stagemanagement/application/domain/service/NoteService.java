package be.heh.dst.stagemanagement.application.domain.service;

import be.heh.dst.stagemanagement.application.domain.model.Note;
import be.heh.dst.stagemanagement.application.port.in.NotePortIn;
import be.heh.dst.stagemanagement.application.port.out.NotePortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NotePortIn{

    private final NotePortOut notePortOut;

    @Autowired
    public NoteService(NotePortOut notePortOut) {
        this.notePortOut = notePortOut;
    }

    @Override
    public List<Note> getAllNotes() {
        return notePortOut.findAll();
    }

    @Override
    public Note getNoteById(Integer idNote) {
        return notePortOut.findById(idNote);
    }

    @Override
    public Note addNote(Note note) {
        return notePortOut.save(note);
    }

    @Override
    public void deleteNoteById(Integer idNote) {
        notePortOut.deleteById(idNote);
    }
}