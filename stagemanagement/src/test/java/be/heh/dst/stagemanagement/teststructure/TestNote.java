package be.heh.dst.stagemanagement.teststructure;

import be.heh.dst.stagemanagement.application.domain.model.Note;
import be.heh.dst.stagemanagement.application.domain.service.NoteService;
import be.heh.dst.stagemanagement.application.port.out.NotePortOut;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestNote {

    @Test
    public void testGetAllNotes() {
        // Initialisation des données
        Note note1 = new Note(1, 3, 2, 4, 5, 1);
        Note note2 = new Note(2, 4, 3, 5, 1, 2);
        List<Note> expectedNotes = Arrays.asList(note1, note2);

        // Mocker le port de sortie
        NotePortOut mockNotePortOut = Mockito.mock(NotePortOut.class);
        Mockito.when(mockNotePortOut.findAll()).thenReturn(expectedNotes);

        // Création du service à tester
        NoteService noteService = new NoteService(mockNotePortOut);

        // Appel de la méthode à tester
        List<Note> actualNotes = noteService.getAllNotes();

        // Assertion
        assertEquals(expectedNotes, actualNotes);
    }

    @Test
    public void testGetNoteById() {
        // Initialisation des données
        int id = 1;
        Note expectedNote = new Note(id, 3, 2, 4, 5, 1);

        // Mocker le port de sortie
        NotePortOut mockNotePortOut = Mockito.mock(NotePortOut.class);
        Mockito.when(mockNotePortOut.findById(id)).thenReturn(expectedNote);

        // Création du service à tester
        NoteService noteService = new NoteService(mockNotePortOut);

        // Appel de la méthode à tester
        Note actualNote = noteService.getNoteById(id);

        // Assertion
        assertEquals(expectedNote, actualNote);
    }

    @Test
    public void testAddNote() {
        // Initialisation des données
        Note newNote = new Note(null, 3, 2, 4, 5, 1);
        Note expectedNote = new Note(1, 3, 2, 4, 5, 1);

        // Mocker le port de sortie
        NotePortOut mockNotePortOut = Mockito.mock(NotePortOut.class);
        Mockito.when(mockNotePortOut.save(newNote)).thenReturn(expectedNote);

        // Création du service à tester
        NoteService noteService = new NoteService(mockNotePortOut);

        // Appel de la méthode à tester
        Note actualNote = noteService.addNote(newNote);

        // Assertion
        assertEquals(expectedNote, actualNote);
    }

    @Test
    public void testDeleteNoteById() {
        // Initialisation des données
        int id = 1;

        // Mocker le port de sortie
        NotePortOut mockNotePortOut = Mockito.mock(NotePortOut.class);
        Mockito.doNothing().when(mockNotePortOut).deleteById(id);

        // Création du service à tester
        NoteService noteService = new NoteService(mockNotePortOut);

        // Appel de la méthode à tester
        noteService.deleteNoteById(id);

        // Assertion
        Mockito.verify(mockNotePortOut).deleteById(id);
    }
}
