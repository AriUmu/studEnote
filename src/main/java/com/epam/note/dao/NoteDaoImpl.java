package com.epam.note.dao;

import com.epam.note.model.Note;
import com.epam.note.persistence.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteDaoImpl implements dao<Note> {

    @Autowired
    NoteRepository noteRepository;


    @Override
    public void create(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void update(Note note) {
    }

    @Override
    public void delete(Note item) {

    }

    @Override
    public List<Note> getAll() {
        return null;
    }

    @Override
    public Note getById(long id) {
        return noteRepository.getById(id);
    }
}
