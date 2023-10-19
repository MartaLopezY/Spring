package com.example.app.controllers;


import com.example.app.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping({"", "/", "/home", "/index"})
    public  String showMain(Model model) {
        model.addAttribute("usuario",new Usuario());
        return "indexView";
    }
    @PostMapping({ "/index/submit"})
    public  String showMain(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/home";

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
