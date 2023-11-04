package com.example.app.controllers;



import com.example.app.entity.Pais;
import com.example.app.services.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {


    @Autowired
    JuegoService juegoService;



    @GetMapping({ "/","/myForm"})
    public  String showForm(Model model) {
        model.addAttribute("paises", juegoService.getPaises());
        model.addAttribute("pais", new Pais());
        return "index";
    }


    @PostMapping("/myForm/submit")
    public String guardar(@ModelAttribute Pais pais,Model model) {
if(pais.getNombre().equals(""))
    return "redirect:/";
        model.addAttribute("pais",pais);
        model.addAttribute("lista", juegoService.getPaises());
        model.addAttribute("capital",juegoService.getPais(pais.getNombre()).getCapital());
        model.addAttribute("poblacion",juegoService.getPais(pais.getNombre()).getPoblacion());
        return "index";
    }



}