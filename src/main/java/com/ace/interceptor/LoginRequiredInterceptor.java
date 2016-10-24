package com.ace.interceptor;

import com.ace.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by leaf.ye on 2016/7/21.
 */
public class LoginRequiredInterceptor implements HandlerInterceptor {
    private static final String IGNORE_URI = "/login";
    private static final String REGISTER_URI = "/register";


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        if (request.getRequestURL() != null && (request.getRequestURL().toString().contains(IGNORE_URI) || request.getRequestURL().toString().contains(REGISTER_URI))) {
            return true;
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            //request.getRequestDispatcher("").forward(request, response);
            response.sendRedirect("");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
