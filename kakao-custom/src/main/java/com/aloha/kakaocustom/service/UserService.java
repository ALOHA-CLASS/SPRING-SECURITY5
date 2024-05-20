package com.aloha.kakaocustom.service;

import com.aloha.kakaocustom.domain.UserAuth;
import com.aloha.kakaocustom.domain.UserSocial;
import com.aloha.kakaocustom.domain.Users;

public interface UserService {

    // 로그인
    public boolean login(Users user) throws Exception;

    // 조회
    public Users select(String id) throws Exception;

    // 회원 가입
    public int join(Users user) throws Exception;

    // 회원 수정
    public int update(Users user) throws Exception;

    // 회원 권한 등록
    public int insertAuth(UserAuth userAuth) throws Exception;

    // 소셜 회원 가입
    public int insertSocial(UserSocial userSocial) throws Exception;

    // 소셜 회원 조회
    public UserSocial selectSocial(UserSocial userSocial) throws Exception;

    // 소셜 회원 수정
    public int updateSocial(UserSocial userSocial) throws Exception;

    // 소셜 정보로 회원 조회
    public Users selectBySocial(UserSocial userSocial) throws Exception;
    

}
