package com.epam.note.service;

import com.epam.note.model.Mark;
import com.epam.note.model.Note;

import java.util.List;

public interface NoteService {

    void addNote(Note note);

    void updateNote(Note note);

    Note findNoteById(int id);

    void deleteNote(Note note);

    List<Note> findAllNotes();

    List<Note> findNoteByMark(Mark mark);
}
