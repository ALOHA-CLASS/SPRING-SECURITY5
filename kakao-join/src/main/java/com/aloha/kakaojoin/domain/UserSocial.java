package com.aloha.kakaojoin.domain;

import java.util.Date;

import lombok.Data;

@Data
public class UserSocial {
    private String id;
    private String userId;
    private String provider;
    private String socialId;
    private Date createdAt;
    private Date updatedAt;
}
