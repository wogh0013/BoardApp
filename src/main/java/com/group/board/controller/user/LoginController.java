package com.group.board.controller.user;

import com.group.board.domain.user.UserDto;
import com.group.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    /* 로그인 페이지 */
    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    /* 로그인 */
    @PostMapping("/login")
    public String login(String userId, String userPw, HttpSession session, Model model) {
        UserDto user = userService.login(userId, userPw);

        if (user != null) {
            session.setAttribute("loginUser", user);    //로그인유저 세션 생성
            return "redirect:/";
        } else {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 잘못되었습니다.");
            model.addAttribute("userId", userId);
            model.addAttribute("userPw", userPw);
            return "user/login";
        }
    }

    /* 로그아웃 */
    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); //세션 전체 초기화
        return "redirect:/login";
    }
}
