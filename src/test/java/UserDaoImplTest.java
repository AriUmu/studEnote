import com.epam.note.dao.UserDaoImpl;
import com.epam.note.model.User;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;


public class UserDaoImplTest {
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void getAll() {
        UserDaoImpl userDao = new UserDaoImpl(sessionFactory);
        List<User> userList = userDao.getAll();
        assertFalse(userList.isEmpty());
    }

    @Test
    public void getByIdTest() {
        UserDaoImpl userDao = new UserDaoImpl(sessionFactory);
        User byId = userDao.getById(1);
        assertFalse(byId == null);
    }

}
