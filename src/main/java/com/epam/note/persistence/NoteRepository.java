package com.epam.note.persistence;

import com.epam.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface NoteRepository extends JpaRepository<Note, Long> {


    Note save(Note note);
    Note getById(long i);
    void deleteById(long i);

    void deleteByTitle(String title);

    void deleteAllByDate(LocalDateTime dateTime);

    void deleteAllByIdNotebook(long idNotebook);


}
