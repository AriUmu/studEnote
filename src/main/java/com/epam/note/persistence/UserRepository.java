package com.epam.note.persistence;

import com.epam.note.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getById(int i);
    User getByName(String name);
    User getByLogin(String login) throws NullPointerException;
    void deleteById(int id);
}
