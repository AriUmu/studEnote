package persistenceTest;

import com.epam.note.config.AppConfig;
import com.epam.note.model.User;
import com.epam.note.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserRepTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getAll() {
        User user = new User();
        user.setName("Ari");
        user.setLogin("Ariha@yandex.ru");
        user.setPassword("1234");
        userRepository.save(user);
        List<User> all = userRepository.findAll();
        assertTrue(!all.isEmpty());
    }


    @Test
    public void getByName() {
        User user = new User();
        user.setName("Trololo");
        user.setLogin("Ariha@yandex.ru");
        user.setPassword("1234");

        userRepository.save(user);
        User one = userRepository.getByName("Trololo");
        assertThat(one.getName(), is("Trololo"));
    }

    @Test
    public void deleteById() {
        User user = new User();
        user.setName("Peri");
        user.setLogin("Pasha@yandex.ru1");
        user.setPassword("1234");

        userRepository.save(user);
        userRepository.delete(user);
        assertTrue(true);
    }

    @Test
    public void existUser(){
        User user = new User();
        user.setId(6);
        user.setName("Coco");
        user.setLogin("blabla");
        user.setPassword("1234");

        userRepository.save(user);

        User byLogin = userRepository.getByLogin("blabla");
        assertThat(byLogin.getLogin(), is("blabla"));


    }

}
