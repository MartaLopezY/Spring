package com.example.app.controllers;


import com.example.app.entity.FormInfo;
import com.example.app.services.FormInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller
public class MainController {


    @Autowired
    FormInfoService formInfoService;



    @GetMapping({"/myForm", "/"})
    public  String showForm(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "index";
    }


    @PostMapping("/myForm/submit")
    public String guardar(@ModelAttribute FormInfo formInfo,Model model) {
        formInfoService.agregar(formInfo);
        model.addAttribute("lista",formInfoService.lista);
        return "tabla";
    }



}