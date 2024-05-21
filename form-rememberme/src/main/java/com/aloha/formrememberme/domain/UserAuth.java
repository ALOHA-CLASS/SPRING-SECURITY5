package com.aloha.formrememberme.domain;

import lombok.Data;

@Data
public class UserAuth {
    private String id;
    private String username;
    private String auth;
}
