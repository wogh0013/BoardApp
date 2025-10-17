package com.group.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")     //전체 경로 검사
                .excludePathPatterns(       //로그인 예외 경로
                        "/"
                        , "/login/**"
                        , "/join/**"
                        , "/css/**", "/js/**", "/images/**" //정적 리소스
                );
    }

}
