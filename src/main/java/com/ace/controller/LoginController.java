package com.ace.controller;

import com.ace.entity.User;
import com.ace.request.CreateUserRequest;
import com.ace.service.LoginService;
import com.ace.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leaf.ye on 2016/7/8.
 */
@Controller
public class LoginController {

    @Inject
    UserService userService;
    @Inject
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        User user = loginService.login(request.getParameter("userName"), request.getParameter("password"));
        User user1 = userService.getById(1);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "index";
        }
        return "login";
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
        User user = userService.getById(2);
        System.out.println(user.getUserName());
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(@RequestBody CreateUserRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        userService.registerUser(user);
        return map;
    }
}
