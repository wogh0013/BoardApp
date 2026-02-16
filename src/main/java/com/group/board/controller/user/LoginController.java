package com.group.board.controller.user;

import com.group.board.domain.user.UserDto;
import com.group.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String login(String userId, String userPw, HttpSession session, RedirectAttributes redirectAttributes) {
        UserDto user = userService.login(userId, userPw);

        //로그인 성공 및 로그인유저 세션 생성
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute("msgCode", "error.login.failed");
        redirectAttributes.addFlashAttribute("userId", userId);

        return "redirect:/login";
    }

    /* 로그아웃 */
    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); //세션 전체 초기화
        return "redirect:/login";
    }
}
