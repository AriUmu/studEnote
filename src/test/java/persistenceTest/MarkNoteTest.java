package persistenceTest;


import com.epam.note.Application;
import com.epam.note.model.Mark;
import com.epam.note.model.Note;
import com.epam.note.persistence.MarkRepository;
import com.epam.note.persistence.NoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = Application.class)
public class MarkNoteTest {

    @Autowired
    MarkRepository markRepository;

    @Autowired
    NoteRepository noteRepository;

    @Test
    public void createMarkNote(){

        Mark mark  = new Mark();
        mark.setId(1);
        mark.setTitle("Zametochka");
        markRepository.save(mark);

        Note note  = new Note();
        note.setTitle("Zametochka2");
        note.setText("Жил-был карась," +
                "вот и сказка началась." +
                "Жил был налим," +
                "вот и сказки половина." +
                "Жил был тунец," +
                "вот и сказочки конец.");
        note.setDate(new Date());
        note.setIdNotebook(1);
        noteRepository.save(note);

    }
}
