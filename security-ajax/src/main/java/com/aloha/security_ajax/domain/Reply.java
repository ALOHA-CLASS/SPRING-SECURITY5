package com.aloha.security_ajax.domain;


import lombok.Data;

@Data
public class Reply {
  private int userNo;  
  private int boardNo;  
  private String content;
}
