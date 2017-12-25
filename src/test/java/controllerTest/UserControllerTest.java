package controllerTest;

import com.epam.note.Application;
import com.epam.note.model.User;
import com.epam.note.service.UserService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Application.class)
public class UserControllerTest {

//    @Mock
//    private UserService userService;
//
//    @Autowired
//    private ResourceLoader resourceLoader;
//
//    private MockMvc mockMvc;
//
//    @Test
//    public void saveUser() throws Exception {
//        User user = new User("Ivan", "Ivan@login", "qwerty");
//
//        when(userService.saveUser(user)).thenReturn(user);
//
//        mockMvc.perform(post("/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(String.valueOf(resourceLoader.getResource("/json/user.json"))))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("name", is("Ivan")));
//
//
//    }
//
//    @Test
//    public void loginUser() throws Exception {
//        User user = new User("Ivan", "Ivan@login", "qwerty");
//
//        userService.saveUser(user);
//        when(userService.saveUser(user)).thenReturn(user);
//
//        mockMvc.perform(get("/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(user.toString()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("name", is("Ivan")));
//    }

}
