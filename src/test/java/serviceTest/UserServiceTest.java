package serviceTest;

import com.epam.note.config.AppConfig;
import com.epam.note.model.User;
import com.epam.note.persistence.UserRepository;
import com.epam.note.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserServiceTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void saveUser() throws Exception {

        User user = new User();
        user.setId(2);
        user.setName("Pasha12");
        user.setLogin("Pasha12@yandex.ru");
        user.setPassword("1234");
        assertTrue(userService.saveUser(user));
    }

    @Test
    public void accessUserPageTest() throws Exception {
        User user = new User("Ivan", "Ivan@inan.com", "I5667");
        userService.saveUser(user);
        boolean b = userService.accessUserPage(user);
        assertTrue(b);
    }



}
