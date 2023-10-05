package com.example.app.controllers;


import com.example.app.services.numerosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class NumerosController {
  @Autowired
  numerosServiceImpl numerosService;


  @GetMapping({"/","/list",""})
  public String showList(Model model){
    model.addAttribute("cantidadTotal",numerosService.lista.size());
    model.addAttribute("listaNumeros",numerosService.lista);
    return "listView";
  }
  @GetMapping("/new")
  public String showNew(){
   numerosService.agregar();
    return "redirect:/list";
  }
  @GetMapping("/delete/{id}")
  public String showDelete (@PathVariable Integer id){
    numerosService.delete(id);
    return "redirect:/list";
  }

}
