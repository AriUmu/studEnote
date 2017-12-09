import com.epam.note.config.AppConfig;
import com.epam.note.dao.MarkDaoImpl;
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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class MarkDaoImplTest {

    @Autowired
    MarkRepository markRepository;
    @Autowired
    MarkDaoImpl markDao;// = new MarkDaoImpl();

    @Test
    public void getMarkByIdTest(){
        Mark mark  = new Mark();
        mark.setId(1);
        mark.setTitle("Zametochka");
        markDao.create(mark);
        Mark testMark = markDao.getById(1);
        markRepository.getById(1);
        assertThat(testMark, is(mark));
    }
    @Test
    public void deleteMarkByTitleTest(){
        Mark mark  = new Mark();
        mark.setId(1);
        mark.setTitle("Zametochka");
        markDao.create(mark);
        Mark testMark = markDao.getById(1);
        assertThat(testMark, is(mark));
        testMark = markDao.getById(1);
        markDao.delete(mark);

//        assertThat(testMark, (mark));

    }
}
