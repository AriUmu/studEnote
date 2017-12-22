package com.epam.note.persistence;

import com.epam.note.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends CrudRepository<Mark, Long> {



    Mark save(Mark note);

    Mark getMarkById(long id);

    Mark getMarkByTitle(String title);

    void deleteMarkByTitle(String title);

    void deleteMarkById(long id);

}
