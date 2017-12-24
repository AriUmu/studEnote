package persistenceTest;

import com.epam.note.Application;
import com.epam.note.model.Mark;
import com.epam.note.persistence.MarkRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = Application.class)
public class MarkRepTest {

    private Logger logger = LoggerFactory.getLogger(MarkRepTest.class);

    @Autowired
    MarkRepository markRepository;

    @Test
    public void getMarkByIdTest(){
        Mark mark  = new Mark();
        mark.setTitle("Zametochka1234");
        markRepository.save(mark);
        long id = markRepository.getMarkByTitle("Zametochka1234").getId();
        Mark byId = markRepository.getMarkById(id);

        logger.info("Mark " + byId.getTitle() + " was successfully added");
        assertThat(byId.getTitle(), is(mark.getTitle()));
    }
    @Test
    public void deleteMarkByTitleTest(){
        Mark mark  = new Mark();
        mark.setTitle("Zametochka111");
        Mark save = markRepository.save(mark);
        assertThat(save, is(mark));
        markRepository.delete(mark);
    }
}
