package com.epam.note.service.Impl;

import com.epam.note.model.Notebook;
import com.epam.note.persistence.NotebookRepository;
import com.epam.note.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    NotebookRepository notebookRepository;

    @Override
    public void createNotebook(Notebook notebook) {
        if (notebookRepository.getNotebookByTitle(notebook.getTitle()) == null) {
            notebookRepository.save(notebook);
        } else {
            throw new RuntimeException("Such notebook exist already");
        }
    }

    @Override
    public void deleteNotebook(Notebook notebook) {
        if(notebookRepository.getNotebookById(notebook.getId()) != null){
            notebookRepository.deleteNotebookById(notebook.getId());
        } else {
            throw new RuntimeException("This notebook was deleted yet");
        }
    }
}
