package persistenceTest;

import com.epam.note.config.AppConfig;
import com.epam.note.model.Mark;
import com.epam.note.model.Note;
import com.epam.note.persistence.MarkRepository;
import com.epam.note.persistence.NoteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

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
        note.setDate(LocalDateTime.now());
        note.setIdNotebook(1);
        noteRepository.save(note);

//        markNote.addMark(mark, note);
//        List<Note> notes = markNote.getMarkNoteHashMap().get(mark);
//
//        for (Note note1 : notes){
//            if(note1.equals(note)){
//                assertTrue(true);
//                break;
//            }
//        }
    }
}
