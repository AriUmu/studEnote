package com.epam.note.persistence;

import com.epam.note.config.AppConfig;
import com.epam.note.model.Notebook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class NotebookRepoTest {

    @Autowired
    NotebookRepository notebookRepository;

    @Test
    public void getNotebookByIdTest(){
        Notebook notebook  = new Notebook();
        notebook.setTitle("Блокнот");

        notebookRepository.save(notebook);
        long id = notebookRepository.getNotebookByTitle("Блокнот").getId();
        Notebook testNotebook = notebookRepository.getNotebookById(id);
        assertThat(testNotebook, is(notebook));
    }
    @Test
    public void getNotebookByTitleTest(){
        Notebook notebook  = new Notebook();
        notebook.setTitle("Блокнот");

        notebookRepository.save(notebook);
        Notebook testNotebook = notebookRepository.getNotebookByTitle("Блокнот");

        assertThat(testNotebook, is(notebook));
    }

    @Transactional
    @Test
    public void  deleteNotebookById(){
        Notebook notebook  = new Notebook();
        notebook.setTitle("Zametochka");
        notebookRepository.save(notebook);
        long id = notebookRepository.getNotebookByTitle("Zametochka").getId();
        Notebook testMark = notebookRepository.getNotebookById(id);
        assertThat(testMark, is(notebook));

        notebookRepository.deleteNotebookById(notebook.getId());
        testMark = notebookRepository.getNotebookById(1);
        assertThat(null,is(testMark));
    }
}
