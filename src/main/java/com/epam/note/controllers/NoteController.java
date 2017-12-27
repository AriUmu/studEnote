package com.epam.note.controllers;

import com.epam.note.model.Note;
import com.epam.note.service.NoteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "Add new user",
            notes = "Lets create new note")
    public ResponseEntity<String> addNote(Note note) {
        noteService.addNote(note);
        return new ResponseEntity<>("Add Note: " + note, HttpStatus.OK);
    }

    @RequestMapping(value = "/{noteId}", method = RequestMethod.GET)
    public ResponseEntity<Note> readNote(@PathVariable String noteId) {
        Note note = noteService.findNoteById(Integer.valueOf(noteId));
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<String> updateNote(Note note) {
        noteService.updateNote(note);
        return new ResponseEntity<>("Update Note: " + note, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> allNotes = noteService.findAllNotes();
        return new ResponseEntity<>(allNotes, HttpStatus.OK);
    }


}