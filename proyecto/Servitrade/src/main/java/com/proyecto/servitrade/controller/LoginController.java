package com.proyecto.servitrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin() { return "/main/login"; }
    @GetMapping("/logout")
    public String showLogout() { return "/main/logout"; }
}
