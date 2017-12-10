package com.epam.note.repos;

import com.epam.note.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getById(int i);

}
