package com.aloha.kakaojoin.domain;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class CustomUser extends DefaultOAuth2User {

    private Users user;

    public CustomUser(Users user, OAuthAttributes oAuthAttributes) {
        super(user.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList())
            ,oAuthAttributes.getAttribute()
            ,oAuthAttributes.getNameAttributeKey() )
            ;
        this.user = user;
    }

}
