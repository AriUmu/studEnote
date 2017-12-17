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
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    protected static Logger logger = LoggerFactory.getLogger(UserService.class);
    /*
    Register  new user
     */
    @Override
    public boolean saveUser(User user) throws Exception {
        if (userRepository.getByLogin(user.getLogin()) == null) {
            user.setPassword(encoderPass(user.getPassword()));
            userRepository.save(user);
            logger.info("User save succesfully");
            return true;
        } else {
            throw new Exception("The same login is exists yet!");
        }
    }

    /*
    Login in enote
     */
    @Override
    public boolean accessUserPage(User user) throws Exception {
        if (userRepository.getById(user.getId()) != null) {
            if (userRepository.getById(user.getId()).getPassword().equals(user.getPassword())) {
                logger.info("User successfully accessed to the page");
                return true;
            }
            System.out.println(encoderPass(user.getPassword() + " ??????"));
            throw new Exception("The password is not correct!");
        }
        return false;
    }


    @Override
    public void updateUserPassword(String LastPassword, String newPassword) {

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
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
