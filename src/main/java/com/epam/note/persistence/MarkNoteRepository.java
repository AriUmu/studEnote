package com.epam.note.persistence;

import com.epam.note.model.MarkNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkNoteRepository extends JpaRepository<MarkNote, Long>{
    //find all note by metka
    List<Integer> findAllById_mark(int id);


}
