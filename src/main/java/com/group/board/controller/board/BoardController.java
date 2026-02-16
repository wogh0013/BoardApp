package com.group.board.controller.board;

import com.group.board.domain.board.RestaurantDto;
import com.group.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("restaurantList", boardService.getRestaurantList());
        if (!model.containsAttribute("restaurantForm")) {
            model.addAttribute("restaurantForm", new RestaurantDto());
        }
        return "board/list";
    }

    @PostMapping("/add")
    public String addRestaurant(@Valid @ModelAttribute("restaurantForm") RestaurantDto restaurantDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.restaurantForm", bindingResult);
            redirectAttributes.addFlashAttribute("restaurantForm", restaurantDto);
            redirectAttributes.addFlashAttribute("msgCode", "error.board.required");
            return "redirect:/board/list";
        }

        boardService.addRestaurant(restaurantDto);
        redirectAttributes.addFlashAttribute("msgCode", "success.board.add");
        return "redirect:/board/list";
    }
}