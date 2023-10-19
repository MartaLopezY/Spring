package com.example.app.controllers;

import com.example.app.entity.Divisor;
import com.example.app.entity.Fecha;
import com.example.app.entity.Primo;
import com.example.app.entity.Triangulo;
import com.example.app.service.CalculosServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping({"/calculos"})
public class CalculosController {
    @Autowired
    CalculosServiceImpl calculosService;
    @GetMapping({""})
    public String showForms(Model model) {

        model.addAttribute("Primo", new Primo());
        model.addAttribute("Divisor", new Divisor());
        model.addAttribute("Triangulo", new Triangulo());
        return "calculosnumericos";
    }
    @PostMapping ({"/primo"})
    public String showResults(Model model, @Valid Primo primo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/primo?error";
        model.addAttribute("numero", primo.getNumero());
        model.addAttribute("primo", calculosService.esPrimo(primo.getNumero()));

        return "primo";
    }

    @PostMapping({"/primo?error", "/hipotenusa?error", "/sinRepetidos?error", "/divisores?error"})
    public String showError() {
        return "error";
    }


    @PostMapping({"/hipotenusa"})
    public String showHipotenusa(Model model, @Valid Triangulo triangulo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/hipotenusa?error";
        model.addAttribute("x", triangulo.getCateto1());
        model.addAttribute("y", triangulo.getCateto2());
        model.addAttribute("hipotenusa", calculosService.hipotenusa( triangulo.getCateto1(), triangulo.getCateto2()));
        return "hipotenusa";
    }

    @PostMapping({"/divisores"})
    public String showDiv(Model model, @Valid Divisor divisor, BindingResult bindingResult) {
        model.addAttribute("num", divisor.getNumero());
        if (bindingResult.hasErrors()) return "redirect:/divisores?error";
        model.addAttribute("lista", calculosService.divisores(divisor.getNumero()));
            return "divisores";

    }
}


