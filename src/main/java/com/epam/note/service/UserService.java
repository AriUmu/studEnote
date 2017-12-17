package com.epam.note.service;

import com.epam.note.model.User;

public interface UserService {

    User saveUser (User user) throws Exception;

    boolean accessUserPage(User user) throws Exception;

    void updateUserPassword(String LastPassword, String newPassword);
}
