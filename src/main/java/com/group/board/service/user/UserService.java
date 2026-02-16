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

    /* 회원가입 */
    public void join(UserDto userDto) {
        userDto.setUserPw(passwordEncoder.encode(userDto.getUserPw()));
        userMapper.insertUser(userDto);
    }

    /* 회원가입 시 ID 중복 여부 체크 */
    public String selectUserId(String userId){
        return userMapper.selectUserId(userId);
    }

    /* 로그인 */
    public UserDto login(String userId, String userPw){
        UserDto dbUser = userMapper.selectUserById(userId);
        //패스워드 검증
        if (dbUser != null && passwordEncoder.matches(userPw, dbUser.getUserPw())) {
            return dbUser;
        }

        return null;
    }

    /* 회원탈퇴 */
    public void deleteUser(String userId){
        userMapper.deleteUser(userId);
    }
}
