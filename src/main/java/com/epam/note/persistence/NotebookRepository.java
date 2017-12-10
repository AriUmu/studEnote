package com.epam.note.persistence;

import com.epam.note.model.Note;
import com.epam.note.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepository extends JpaRepository<Notebook, Long>{

    Notebook getNotebookById(long id);

    Notebook getNotebookByTitle(String title);

    void deleteNotebookById(long id);
}
