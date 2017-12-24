package com.epam.note.persistence;

import com.epam.note.model.Note;
import org.springframework.data.repository.CrudRepository;


public interface NoteRepository extends CrudRepository<Note, Long> {


    Note save(Note note);
  
    Note getById(long i);

    Note getNoteByTitle(String title);

}
