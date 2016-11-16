package com.ace.service;

import com.ace.dao.UserDAO;
import com.ace.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by leaf.ye on 2016/8/25.
 */
@Service
public class UserService {

    @Inject
    UserDAO userDAO;

    public User getById(int id) {
        return userDAO.getById(id);
    }

    public User findByNameAndPassword(String userName, String password) {
        return userDAO.findByNameAndPassword(userName, password);
    }

    public void registerUser(User user) {
        userDAO.registerUser(user);
    }

    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }
}
