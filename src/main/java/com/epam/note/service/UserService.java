package com.epam.note.service;

import com.epam.note.model.User;

public interface UserService {

    User saveUser (User user) throws Exception;

    User accessUserPage(User user) throws Exception;

    void updateUserPassword(Integer userId, String LastPassword, String newPassword);

    User getUserById(int id);
}
