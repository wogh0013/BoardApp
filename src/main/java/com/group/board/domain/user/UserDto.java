package com.group.board.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {

    private String userId;
    private String userPw;
    private String userNm;
    private String userEmail;

    private String regDt;
    private String regId;
    private String modiDt;
    private String modiId;
}
