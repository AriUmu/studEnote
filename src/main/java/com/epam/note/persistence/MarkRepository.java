package com.epam.note.persistence;

import com.epam.note.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {


    Mark save(Mark note);

    Mark getMarkById(long i);

    Mark getMarkByTitle(String title);

    void deleteMarkByTitle(String title);

    void deleteMarkById(long id);


}
