package serviceTest;

import com.epam.note.Application;
import com.epam.note.model.User;
import com.epam.note.persistence.UserRepository;
import com.epam.note.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void saveUser() throws Exception {

        User user = new User();
        user.setName("Pasha12");
        user.setLogin("Pasha12@yandex.trololo");
        user.setPassword("123454");
        assertEquals("Pasha12", userService.saveUser(user).getName());
    }

    @Test
    public void accessUserPageTest() throws Exception {
        User user = new User("Ivan", "Ivan@inan.com", "I5667");
        userService.saveUser(user);
        boolean b = userService.accessUserPage(user);
        assertTrue(b);
    }



}
