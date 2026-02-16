package com.group.board.mapper;

import com.group.board.domain.user.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(UserDto userDto);

    String selectUserId(String userId);

    UserDto selectUserById(String userId);

    void deleteUser(String userId);
}
