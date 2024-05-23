package com.aloha.form.service;

import com.aloha.form.domain.UserAuth;
import com.aloha.form.domain.Users;

public interface UserService {
    
    // 로그인
    public boolean login(Users user) throws Exception;

    // 조회
    public Users select(String username) throws Exception;

    // 회원 가입
    public int join(Users user) throws Exception;

    // 회원 수정
    public int update(Users user) throws Exception;

    // 회원 권한 등록
    public int insertAuth(UserAuth userAuth) throws Exception;

}
