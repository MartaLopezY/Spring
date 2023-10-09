package com.example.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping({"", "/", "/home", "/index"})
    public  String showMain() {

        return "indexView";
    }
    @GetMapping({ "/index/"})
    public  String showMain(@RequestParam String usuario, Model model) {
        model.addAttribute("usuario", usuario);
        return "indexUserView";
    }
    @GetMapping("/contacta")
    public  String showContacta() {

        return "contactaView";
    }
    @GetMapping("/producto")
    public  String showProducto(Model model) {
        List<String> listaProductos = new ArrayList<>(Arrays.asList("Prod1", "Prod2", "Prod3"));
        model.addAttribute("listaProd", listaProductos);
        return "productoView";
    }
    @GetMapping("/quienessomos")
    public  String showQuienesSomos() {

        return "quienes-somosView";
    }

}