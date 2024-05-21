package com.aloha.form.config;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    // 스프링 시큐리티 설정 메소드
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // ✅ 인가 설정
        http.authorizeRequests(requests -> requests
                                            .antMatchers("/**").permitAll()
                                            .anyRequest().permitAll()
                                            );

        // 🔐 폼 로그인 설정
        http.formLogin(withDefaults());
        return http.build();

    }


     /**
     * 👮‍♂️🔐 사용자 인증 관리 빈 등록 메소드
     * JDBC 인증 방식
     * ✅ 데이터 소스 (URL, ID, PW) - application.properties
     * ✅ SQL 쿼리 등록         
     * ⭐ 사용자 인증 쿼리
     * ⭐ 사용자 권한 쿼리
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager userDetailsManager 
                = new JdbcUserDetailsManager(dataSource);

        // 사용자 인증 쿼리
        String sql1 = " SELECT username, password, enabled "
                    + " FROM user "
                    + " WHERE username = ? "
                    ;
        // 사용자 권한 쿼리
        String sql2 = " SELECT username, auth "
                    + " FROM user_auth "
                    + " WHERE username = ? "
                    ;
        userDetailsManager.setUsersByUsernameQuery(sql1);
        userDetailsManager.setAuthoritiesByUsernameQuery(sql2);
        return userDetailsManager;
    }
    
}
