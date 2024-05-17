package com.aloha.kakaojoin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

    /**
     * 메인 화면
     * 🔗 [GET] - / 
     * 📄 index.html
     * @return
     */
    @GetMapping("/")
    public String home() {
        log.info(":::::::::: 메인 화면 ::::::::::");
        return "/index";
    }
    
}
