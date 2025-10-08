package com.group.board.controller.user;

import com.group.board.domain.user.UserDto;
import com.group.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String joinForm() {
        return "user/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserDto userDto, RedirectAttributes redirectAttributes) {
        String userId = userService.getUserId(userDto.getUserId());
        if(userId != null && !userId.isEmpty()){
            redirectAttributes.addFlashAttribute("existMsg", "이미 존재하는 ID입니다.");
            return "redirect:/join";
        }

        userService.join(userDto);
        redirectAttributes.addFlashAttribute("msg", "회원가입이 완료되었습니다.");

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }
}
