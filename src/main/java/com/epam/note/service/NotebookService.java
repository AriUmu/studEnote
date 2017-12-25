package com.epam.note.service;

import com.epam.note.model.Notebook;

public interface NotebookService {

    void createNotebook(Notebook notebook);

    void deleteNotebook(Notebook notebook);
}
