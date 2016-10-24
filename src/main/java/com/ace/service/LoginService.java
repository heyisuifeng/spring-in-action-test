package com.ace.service;

import com.ace.dao.LoginDAO;
import com.ace.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by leaf.ye on 2016/8/17.
 */
@Service
public class LoginService {
    @Inject
    private LoginDAO loginDAO;

    public User login() {
        return loginDAO.login();
    }

    public User login(String userName, String password) {
        return loginDAO.login(userName, password);
    }
}
