package com.group.board.controller.user;

import com.group.board.domain.user.UserDto;
import com.group.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/join")
public class JoinController {

    private final UserService userService;

    /* 회원가입 페이지 */
    @GetMapping
    public String joinForm() {
        return "user/join";
    }

    /* 회원가입 */
    @PostMapping
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
            model.addAttribute("existMsg", "이미 존재하는 아이디입니다.");
            return "redirect:/join";
        }

        if (!userDto.getUserPw().equals(userDto.getUserPwConfirm())) {
            redirectAttributes.addFlashAttribute("notMatchMsg", "비밀번호가 일치하지 않습니다.");
            return "redirect:/join";
        }

        userService.join(userDto);
        redirectAttributes.addFlashAttribute("msg", "회원가입이 완료되었습니다.");

        return "redirect:/login";
    }

    @ResponseBody
    @GetMapping("/checkId")
    public boolean checkId(@RequestParam("userId") String userId){
        String existingId = userService.selectUserId(userId);
        return (existingId == null || existingId.isEmpty()); //사용 가능한 아이디라면 true 리턴
    }
}
