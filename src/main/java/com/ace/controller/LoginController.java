package com.ace.controller;

import com.ace.entity.User;
import com.ace.request.CreateUserRequest;
import com.ace.service.LoginService;
import com.ace.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUserName(), user.getPassword()));
            request.getSession().setAttribute("user", user);
            return "redirect:/search";
        } catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/";
        }
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
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
