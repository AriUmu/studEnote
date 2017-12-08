package com.epam.note.persistence;

import com.epam.note.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getById(int i);

}
