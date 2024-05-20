package com.aloha.kakaocustom.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aloha.kakaocustom.domain.CustomUser;

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
    public String home(@AuthenticationPrincipal OAuth2User oauth2User
                      ,Model model) {
        log.info(":::::::::: 메인 화면 ::::::::::");

        CustomUser customUser = (CustomUser) oauth2User;
        model.addAttribute("user", customUser);
        return "/index";
    }


    /**
     * 로그인 화면
     * 🔗 [GET] - /login 
     * 📄 login.html
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
    
    
}
