package com.epam.note.controllers;

import com.epam.note.model.User;
import com.epam.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<User> createUser(User user) throws Exception {
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) throws Exception {
        return new ResponseEntity<User>(userService.getUserById(Integer.valueOf(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<String> appdateUserPassword(@RequestBody String oldPass, String newPass, @PathVariable Integer userId ) {
       userService.updateUserPassword(userId, oldPass, newPass);
        return new ResponseEntity<>( HttpStatus.OK);
    }


}

