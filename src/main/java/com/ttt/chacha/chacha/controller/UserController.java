package com.ttt.chacha.chacha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController
{

    @RequestMapping({"/","/index"})
    public String index()
    {
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin()
    {
        return "login";
    }
}
