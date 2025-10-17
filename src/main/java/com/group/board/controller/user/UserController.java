package com.group.board.controller.user;

import com.group.board.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


}
