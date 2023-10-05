package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




    @Controller
    public class MainController {

        @GetMapping({"", "/", "/home", "/index"})
        public  String showMain(Model model) {
            model.addAttribute("fecha", DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now()));
            return "index";
        }
    }


