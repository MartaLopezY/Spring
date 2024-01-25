package com.example.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"", "/", "/home", "/index"})
    public  String showMain() {

        return "indexView";
    }

    @GetMapping("/login")
    public String showLogin() { return "signinView"; }

    @GetMapping("/logout")
    public String showLogout() { return "signoutView"; }
}
