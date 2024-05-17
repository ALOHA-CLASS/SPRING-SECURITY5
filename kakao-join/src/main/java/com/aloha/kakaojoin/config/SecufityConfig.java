package com.aloha.kakaojoin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecufityConfig {

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
                                            .antMatchers("/").permitAll()
                                            .anyRequest().authenticated());
        // 👩‍💻🔐 OAuth2 로그인 기능 활성화
        http.oauth2Login(withDefaults());

        return http.build();
    }

    
}
