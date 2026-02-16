package com.group.board.domain.board;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RestaurantDto {

    private Long id;

    @NotBlank(message = "가게 이름을 입력해 주세요.")
    private String name;

    @NotBlank(message = "지역을 입력해 주세요.")
    private String area;

    @NotBlank(message = "대표 메뉴를 입력해 주세요.")
    private String menu;

    private String memo;
}