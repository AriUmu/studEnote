package persistenceTest;

import com.epam.note.config.AppConfig;
import com.epam.note.model.Mark;
import com.epam.note.persistence.MarkRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class MarkRepTest {

    private Logger logger = LoggerFactory.getLogger(MarkRepTest.class);

    @Autowired
    MarkRepository markRepository;

    @Test
    public void getMarkByIdTest(){
        Mark mark  = new Mark();
        mark.setId(1);
        mark.setTitle("Zametochka");
        markRepository.save(mark);
        Mark byId = markRepository.getMarkById(1);
//
//        Mark mark2  = new Mark();
//        mark.setId(2);
//        mark.setTitle("Zametochka2");
//        markRepository.save(mark);
//        Mark byId2 = markRepository.getMarkById(2);

        logger.info("Mark " + byId.getTitle() + " was successfully added");
        assertThat(byId.getTitle(), is(mark.getTitle()));
    }
    @Test
    public void deleteMarkByTitleTest(){
        Mark mark  = new Mark();
        mark.setId(2);
        mark.setTitle("Zametochka");
        Mark save = markRepository.save(mark);
        assertThat(save, is(mark));
        markRepository.delete(mark);
        assertTrue(markRepository.getMarkById(2) == null);

    }
}
