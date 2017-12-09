package com.epam.note.dao;

import com.epam.note.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements dao<User> {

    @Autowired
    private User user;

    @Override
    public void create(User item) {

    }

    @Override
    public void update(User item) {

    }

    @Override
    public void delete(User item) {

    }

    @Override
    public List<User> getAll() {

       return null;
    }

    @Override
    public User getById(long id) {
        return null;
    }
}
