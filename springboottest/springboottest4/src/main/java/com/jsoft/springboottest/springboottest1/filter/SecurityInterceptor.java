package com.jsoft.springboottest.springboottest1.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jsoft.springboottest.springboottest1.config.WebSecurityConfig;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(WebSecurityConfig.SESSION_KEY) != null)
            return true;

        // 跳转登录
        String url = "/login";
        response.sendRedirect(url);
        return false;
    }
}
