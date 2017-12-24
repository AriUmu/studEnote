package persistenceTest;

import com.epam.note.Application;
import com.epam.note.model.Note;
import com.epam.note.persistence.NoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = Application.class)
public class NoteRepTest {

    @Autowired
    NoteRepository noteRepository;

    @Test
    public void getNoteByIdTest(){
        Note note  = new Note();
        note.setTitle("Zametochka5");
        note.setText("Жил-был карась," +
                "вот и сказка началась." +
                "Жил был налим," +
                "вот и сказки половина." +
                "Жил был тунец," +
                "вот и сказочки конец.");
        note.setDate(new Date());
        note.setIdNotebook(1);

        noteRepository.save(note);
        long id = noteRepository.getNoteByTitle("Zametochka5").getId();
        Note testNote = noteRepository.getById(id);
        assertThat(testNote, is(note));
    }
}
