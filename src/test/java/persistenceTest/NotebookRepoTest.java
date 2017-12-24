package persistenceTest;

import com.epam.note.Application;
import com.epam.note.model.Notebook;
import com.epam.note.persistence.NotebookRepository;
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
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = Application.class)
public class NotebookRepoTest {

    @Autowired
    NotebookRepository notebookRepository;

    @Test
    public void getNotebookByIdTest(){
        Notebook notebook  = new Notebook();
        notebook.setTitle("Notebook");

        notebookRepository.save(notebook);
        long id = notebookRepository.getNotebookByTitle("Notebook").getId();
        Notebook testNotebook = notebookRepository.getNotebookById(id);
        assertThat(testNotebook, is(notebook));
    }
    @Test
    public void getNotebookByTitleTest(){
        Notebook notebook  = new Notebook();
        notebook.setTitle("Bloknote");

        notebookRepository.save(notebook);
        Notebook testNotebook = notebookRepository.getNotebookByTitle("Bloknote");

        assertThat(testNotebook, is(notebook));
    }

    @Transactional
    @Test
    public void  deleteNotebookById(){
        Notebook notebook  = new Notebook();
        notebook.setTitle("Zametochka");
        notebookRepository.save(notebook);
        long id = notebookRepository.getNotebookByTitle("Zametochka").getId();
        Notebook testMark = notebookRepository.getNotebookById(id);
        assertThat(testMark, is(notebook));

        notebookRepository.deleteNotebookById(notebook.getId());
        testMark = notebookRepository.getNotebookById(1);
        assertThat(null,is(testMark));
    }
}
