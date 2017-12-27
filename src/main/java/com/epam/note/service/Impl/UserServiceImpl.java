package com.epam.note.service.Impl;

import com.epam.note.model.User;
import com.epam.note.persistence.UserRepository;
import com.epam.note.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    protected static Logger logger = LoggerFactory.getLogger(UserService.class);
    /*
    Register  new user
     */
    @Override
    public User saveUser(User user) {
        if (userRepository.getByLogin(user.getLogin()) == null) {
            user.setPassword(encoderPass(user.getPassword()));
            userRepository.save(user);
            logger.info("User save succesfully");
            return user;
        } else {
            throw new NullPointerException("The same login is exists yet!");
        }
    }

    /*
    Login in enote
     */
    @Override
    public User accessUserPage(User user) throws Exception {
        if (userRepository.getById(user.getId()) != null) {
            if (userRepository.getById(user.getId()).getPassword().equals(user.getPassword())) {
                logger.info("User successfully accessed to the page");
                return user;
            }
            throw new Exception("The password is not correct!");
        }
        return null;
    }


    @Override
    public void updateUserPassword(Integer userId, String lastPassword, String newPassword) {
        User byId = userRepository.getById(userId);
        String pass = encoderPass(lastPassword);
        if(byId.getPassword().equals(pass)){
            byId.setPassword(encoderPass(newPassword));
            userRepository.save(byId);
        }
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getById(id);
    }


    private static String encoderPass(String passwordToHash) {
        byte[] salt = {'a'};
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error with password");
        }
        return generatedPassword;
    }
}
