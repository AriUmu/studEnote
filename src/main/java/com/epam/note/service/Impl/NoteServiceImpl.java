package com.epam.note.service.Impl;

import com.epam.note.model.Note;
import com.epam.note.persistence.NoteRepository;
import com.epam.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public void addNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public Note findNoteById(int id) {
        return noteRepository.getById(id);
    }

    @Override
    public void deleteNote(Note note) {
        if (noteRepository.getById(note.getId()) != null) {
            noteRepository.delete(note.getId());
        }
    }

    @Override
    public List<Note> findAllNotes() {
        return (List<Note>) noteRepository.findAll();
    }

}
