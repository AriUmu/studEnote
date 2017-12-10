package com.epam.note.persistence;

import com.epam.note.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepository extends JpaRepository<Notebook, Long>{

    Notebook getById(int id);
    void deleteById(int id);
}
