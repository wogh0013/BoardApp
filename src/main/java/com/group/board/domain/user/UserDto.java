package com.group.board.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class UserDto {

    @NotBlank(message = "아이디를 입력해 주세요.")
    private String userId;
    @NotBlank(message = "비밀번호를 입력해 주세요.")
    private String userPw;
    @NotBlank(message = "비밀번호 확인을 입력해 주세요.")
    private String userPwConfirm;
    @NotBlank(message = "이름을 입력해 주세요.")
    private String userNm;
    @NotBlank(message = "이메일을 입력해 주세요.")
    private String userEmail;

    private String regDt;
    private String regId;
    private String modiDt;
    private String modiId;
}
