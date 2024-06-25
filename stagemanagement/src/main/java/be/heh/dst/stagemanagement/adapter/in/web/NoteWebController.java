package be.heh.dst.stagemanagement.adapter.in.web;

import be.heh.dst.stagemanagement.application.domain.model.Note;
import be.heh.dst.stagemanagement.application.port.in.NotePortIn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/note")
@Slf4j
public class NoteWebController {

    private final NotePortIn notePortIn;
    public NoteWebController(NotePortIn notePortIn) {
        this.notePortIn = notePortIn;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return notePortIn.getAllNotes();
    }

    @GetMapping("/{idNote}")
    public Note getNoteById(@PathVariable Integer idNote) {
        return notePortIn.getNoteById(idNote);
    }

    @PostMapping
    @PreAuthorize("hasRole('Stagiaires')")
    public Note addNote(@RequestBody Note note) {
        return notePortIn.addNote(note);
    }

    @DeleteMapping("/{idNote}")
    @PreAuthorize("hasRole('Coordinateurs') or hasRole('Superviseur')")
    public void deleteNoteById(@PathVariable Integer idNote) {
        notePortIn.deleteNoteById(idNote);
    }
}