package com.aloha.kakaocustom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.aloha.kakaocustom.service.OAuthService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private OAuthService oAuthService;

    /**
     * 🔐 스프링 시큐리티 설정 메소드
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 👩‍💼 인가 설정
        http.authorizeRequests(requests -> requests
                                            .antMatchers("/**").permitAll()
                                            .anyRequest().authenticated());
        // 👩‍💻🔐 OAuth2 로그인 
        // ✅ userInfoEndpoint()            : 사용자 정보 설정 객체 가져오기
        // ✅ userService(oAuthService)     : 사용자 정보 설정 객체로, 로그인 후 처리할 구현 클래스 등록
        http.oauth2Login(login -> login
                                    .loginPage("/login")
                                    .userInfoEndpoint() 
                                    .userService(oAuthService)
                                    
                                    );

        return http.build();
    }

    
}
