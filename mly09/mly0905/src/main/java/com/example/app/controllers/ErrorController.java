package com.example.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ErrorController {

    @GetMapping({ "/accessError"})
    public  String showMain() {
        return "/error/errorView";
    }
    @GetMapping({ "/",""})
    public  String show() {
       return "redirect:/public/";
    }
}
