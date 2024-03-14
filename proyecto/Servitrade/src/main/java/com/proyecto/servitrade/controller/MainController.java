package com.proyecto.servitrade.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/public"})
public class MainController {

    @GetMapping({"", "/", "/home", "/index"})
    public  String showMain() {

        return "/main/index";
    }

}

