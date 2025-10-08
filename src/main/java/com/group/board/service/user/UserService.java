package com.group.board.service.user;

import com.group.board.domain.user.UserDto;
import com.group.board.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void join(UserDto userDto) {
        userDto.setUserPw(passwordEncoder.encode(userDto.getUserPw()));
        userMapper.insertUser(userDto);
    }

    public String getUserId(String userId){
        String existUserId = userMapper.getUserId(userId);

        return existUserId;
    }
}
