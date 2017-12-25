package com.epam.note.service;

import com.epam.note.model.User;

public interface UserService {

    User saveUser (User user) throws Exception;

    User accessUserPage(User user) throws Exception;

    void updateUserPassword(String LastPassword, String newPassword);
}
