package com.group.board.controller.user;

import com.group.board.domain.user.UserDto;
import com.group.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/mypage")
    public String userMyPage(HttpSession session, Model model){
        UserDto loginUser = (UserDto) session.getAttribute("loginUser");
        if(loginUser != null){
            model.addAttribute("loginUser", loginUser);
        }
        return "user/myPage";
    }

    @PostMapping("/delete")
    public String deleteUser(HttpSession session, RedirectAttributes redirectAttributes){
        UserDto user = (UserDto) session.getAttribute("loginUser");
        if (user != null) {
            String userId = user.getUserId();
            userService.deleteUser(userId);
            session.invalidate();
        }
        redirectAttributes.addFlashAttribute("msgCode", "success.delete.complete");

        return "redirect:/login";
    }

}
