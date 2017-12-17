package persistenceTest;

import com.epam.note.config.AppConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class MarkNoteTest {

//    @Autowired
//    MarkRepository markRepository;
//
//    @Autowired
//    NoteRepository noteRepository;
//
//    @Test
//    public void createMarkNote(){
//
//        Mark mark  = new Mark();
//        mark.setId(1);
//        mark.setTitle("Zametochka");
//        markRepository.save(mark);
//
//        Note note  = new Note();
//        note.setTitle("Zametochka2");
//        note.setText("Жил-был карась," +
//                "вот и сказка началась." +
//                "Жил был налим," +
//                "вот и сказки половина." +
//                "Жил был тунец," +
//                "вот и сказочки конец.");
//        note.setDate(LocalDateTime.now());
//        note.setIdNotebook(1);
//        noteRepository.save(note);

//        note.addMark(mark);
//
//        for (Mark mark1 : note.getNoteMark()){
//            assertEquals(mark1.getTitle(), "Zametochka");
//        }


//    }
}
