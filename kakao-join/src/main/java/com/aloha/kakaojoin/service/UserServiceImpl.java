package com.aloha.kakaojoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aloha.kakaojoin.domain.CustomUser;
import com.aloha.kakaojoin.domain.UserAuth;
import com.aloha.kakaojoin.domain.UserSocial;
import com.aloha.kakaojoin.domain.Users;
import com.aloha.kakaojoin.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public boolean login(Users user) throws Exception {
        // // 💍 토큰 생성
        String username = user.getUsername();         // 아이디
        String password = user.getPassword();    // 암호화되지 않은 비밀번호
        UsernamePasswordAuthenticationToken token 
            = new UsernamePasswordAuthenticationToken(username, password);
        
        // 토큰에 요청 정보 등록
        // token.setDetails( new WebAuthenticationDetails(request) );

        // 토큰을 이용하여 인증
        Authentication authentication = authenticationManager.authenticate(token);

        // 인증된 사용자 확인
        CustomUser loginUser = (CustomUser) authentication.getPrincipal();
        log.info("인증된 사용자 아이디 : " + loginUser.getUser().getUsername());
        boolean result = authentication.isAuthenticated();

        // 시큐리티 컨텍스트에 등록
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return result;
    }

    @Override
    public Users select(String id) throws Exception {
        Users user = userMapper.select(id);
        return user;
    }

    @Override
    public int join(Users user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);  // 🔒 비밀번호 암호화
        user.setPassword(encodedPassword);

        // 회원 등록
        int result = userMapper.join(user);

        if( result > 0 ) {
            // 회원 기본 권한 등록
            UserAuth userAuth = new UserAuth();
            userAuth.setUsername(username);
            userAuth.setAuth("ROLE_USER");
            result = userMapper.insertAuth(userAuth);
        }
        return result;
    }

    @Override
    public int update(Users user) throws Exception {
        int result = userMapper.update(user);
        return result;
    }

    @Override
    public int insertAuth(UserAuth userAuth) throws Exception {
        int result = userMapper.insertAuth(userAuth);
        return result;
    }

    @Override
    public int insertSocial(UserSocial userSocial) throws Exception {
        int result = userMapper.insertSocial(userSocial);
        return result;
    }

    @Override
    public UserSocial selectSocial(UserSocial userSocial) throws Exception {
        UserSocial selectedUserSocial = userMapper.selectSocial(userSocial);
        return selectedUserSocial;
    }

    @Override
    public int updateSocial(UserSocial userSocial) throws Exception {
        int result = userMapper.updateSocial(userSocial);
        return result;
    }

    @Override
    public Users selectBySocial(UserSocial userSocial) throws Exception {
        Users user = userMapper.selectBySocial(userSocial);
        return user;
    }
    
}
