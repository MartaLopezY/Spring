package com.example.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.sun.beans.introspect.PropertyInfo.Name.bound;


@Controller
public class NumerosController {

  Random random=new Random();
  public Set<Integer> lista=new HashSet<>();

  @GetMapping({"/","/list",""})
  public String showList(Model model){
    model.addAttribute("cantidadTotal",lista.size());
    model.addAttribute("listaNumeros",lista);
    return "listView";
  }
  @GetMapping("/new")
  public String showNew(){
    lista.add(random.nextInt(100) +1);
    return "redirect:/list";
  }
  @GetMapping("/delete/{id}")
  public String showDelete (@PathVariable Integer id){
    lista.remove(id);
    return "redirect:/list";
  }

}
