package serviceTest;


import com.epam.note.model.Note;
import com.epam.note.persistence.NoteRepository;
import com.epam.note.service.Impl.NoteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.time.LocalDateTime;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
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
        note.setDate(LocalDateTime.now());

        noteService.addNote(note);
        verify(noteRepository, times(1)).save(note);
    }
}
