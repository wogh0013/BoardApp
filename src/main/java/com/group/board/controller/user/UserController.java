package com.group.board.controller.user;

import com.group.board.domain.user.UserDto;
import com.group.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /* 회원가입 페이지 */
    @GetMapping("/join")
    public String joinForm() {
        return "user/join";
    }

    /* 회원가입 */
    @PostMapping("/join")
    public String join(@Valid @ModelAttribute UserDto userDto
            , BindingResult result
            , RedirectAttributes redirectAttributes
            , Model model) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            model.addAttribute("errorMessages", errorMessages);
            return "user/join";
        }

        String userId = userService.selectUserId(userDto.getUserId());
        if (userId != null && !userId.isEmpty()) {
            redirectAttributes.addFlashAttribute("existMsg", "이미 존재하는 아이디입니다.");
            return "redirect:/join";
        }

        userService.join(userDto);
        redirectAttributes.addFlashAttribute("msg", "회원가입이 완료되었습니다.");

        return "redirect:/login";
    }

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
