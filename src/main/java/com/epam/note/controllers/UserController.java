package com.epam.note.controllers;

import com.epam.note.model.User;
import com.epam.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.HttpStatus.*;

@Controller
@RequestMapping("http://localhost:8080")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = {"/"})
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<User>(userService.saveUser(user), OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = {"/"})
    public ResponseEntity<User> getUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<User>(userService.accessUserPage(user), OK);
    }


}

