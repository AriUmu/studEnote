package com.epam.note.persistence;

import com.epam.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface NoteRepository extends CrudRepository<Note, Long> {


    Note save(Note note);
  
    Note getById(long i);

    Note getNoteByTitle(String title);

}
