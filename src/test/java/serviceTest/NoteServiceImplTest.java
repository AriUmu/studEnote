package serviceTest;


import com.epam.note.Application;
import com.epam.note.model.Note;
import com.epam.note.persistence.NoteRepository;
import com.epam.note.service.Impl.NoteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.time.LocalDateTime;
import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = Application.class)
public class NoteServiceImplTest {

    @Mock
    NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;

    @Test
    public void addNote() throws Exception {
        Note note = new Note();
        note.setText("Hello! My name is Ari");
        note.setTitle("Hello World");
        note.setIdNotebook(33);
        note.setDate(new Date());

        noteService.addNote(note);
        verify(noteRepository, times(1)).save(note);
    }
}
