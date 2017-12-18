package com.epam.note.controllers;

import com.epam.note.model.User;
import com.epam.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.HttpStatus.*;

@RequestMapping("${api.root}/user")
@CrossOrigin(origins = "${origins}")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<User>(userService.saveUser(user), OK);
    }


}
