package com.example.app.controllers;



import com.example.app.entity.Pais;
import com.example.app.services.PaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class MainController {


    @Autowired
    PaisesService paisesService;



    @GetMapping({ "/","/myForm"})
    public  String showForm(Model model) {
        model.addAttribute("lista", paisesService.getPaises());
        model.addAttribute("pais", new Pais());
        return "index";
    }


    @PostMapping("/myForm/submit")
    public String guardar(@ModelAttribute Pais pais,Model model) {
if(pais.getNombre().equals(""))
    return "redirect:/";
      Pais paisSeleccionado=paisesService.getPais(pais.getNombre());
        model.addAttribute("lista", paisesService.getPais(pais.getNombre()));
        model.addAttribute("capital", paisesService.getPais(pais.getNombre()).getCapital());
        model.addAttribute("poblacion", paisesService.getPais(pais.getNombre()).getPoblacion());
        return "index";
    }



}