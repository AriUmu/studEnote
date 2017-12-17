package com.epam.note.service.Impl;

import com.epam.note.model.Mark;
import com.epam.note.model.Note;
import com.epam.note.persistence.NoteRepository;
import com.epam.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    MarkServiceImpl markService;

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
        noteRepository.delete(note.getId());
    }

    @Override
    public List<Note> findAllNotes() {
        return  noteRepository.findAll();
    }

    @Override
    public List<Note> findNoteByMark(Mark mark) {
        List<Note> notes = markService.getMarkNoteHashMap().get(mark);
        return notes;
    }
}
