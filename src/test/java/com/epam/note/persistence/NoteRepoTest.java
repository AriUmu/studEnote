package com.epam.note.persistence;

import com.epam.note.config.AppConfig;
import com.epam.note.model.Note;
import com.epam.note.persistence.NoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;

import java.time.LocalDateTime;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class NoteRepoTest {

    @Autowired
    NoteRepository noteRepository;

    @Test
    public void getNoteByIdTest() {
        Note note = new Note();
        note.setTitle("Zametochka");
        note.setText("Жил-был карась," +
                "вот и сказка началась." +
                "Жил был налим," +
                "вот и сказки половина." +
                "Жил был тунец," +
                "вот и сказочки конец.");
        note.setDate(LocalDateTime.now());
        noteRepository.save(note);
        long id = noteRepository.getNoteByTitle("Zametochka").getId();
        Note testNote = noteRepository.getById(id);
        assertThat(testNote, is(testNote));
    }

    @Test
    public void getNoteByTitleTest() {
        Note note = new Note();
        note.setTitle("Zametochka1");
        note.setText("Жил-был карась," +
                "вот и сказка началась." +
                "Жил был налим," +
                "вот и сказки половина." +
                "Жил был тунец," +
                "вот и сказочки конец.");
        note.setDate(LocalDateTime.now());
        noteRepository.save(note);
        Note testNote = noteRepository.getNoteByTitle("Zametochka1");
        assertThat(testNote, is(note));
    }
}
