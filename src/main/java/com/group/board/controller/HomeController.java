package com.group.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mainPage(HttpSession session){
        //비로그인 시
        if(session.getAttribute("loginUser") == null){
            return "redirect:/login";
        }

        return "user/mainPage";
    }
}
