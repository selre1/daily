package com.compact.info.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {

    @GetMapping("/login")
    public String GetLoginPage(){
        return "login";
    }

    @GetMapping("/sign-up")
    public String getSignUpPage(){
        return "sign-up";
    }
}
