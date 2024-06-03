package com.aloha.security_ajax.domain;

import lombok.Data;

@Data
public class UserAuth {
    private String id;
    private String username;
    private String auth;
}
