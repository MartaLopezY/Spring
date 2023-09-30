package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"", "/", "/home", "/index"})
    public  String showMain() {

        return "indexView";
    }
    @GetMapping("/contacta")
    public  String showContacta() {

        return "contactaView";
    }
    @GetMapping("/producto")
    public  String showProducto() {

        return "productoView";
    }
    @GetMapping("/quienessomos")
    public  String showQuienesSomos() {

        return "quienes-somosView";
    }

}
