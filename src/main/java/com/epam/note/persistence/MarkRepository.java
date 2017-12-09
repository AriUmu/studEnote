package com.epam.note.persistence;

import com.epam.note.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {


    Mark save(Mark mark);
    Mark getById(long id);

    void deleteById(long id);
    void deleteByTitle(String title);

}
