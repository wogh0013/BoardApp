package com.group.board.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request
                            , HttpServletResponse response
                            , Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        //비로그인 시 로그인 페이지로 리다이렉트
        if (loginUser == null) {
            response.sendRedirect("/login");
            return false;
        }
        
        return true;
    }
}
