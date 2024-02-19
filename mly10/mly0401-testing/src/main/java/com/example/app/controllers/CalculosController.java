package com.example.app.controllers;

import com.example.app.service.CalculosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
@RequestMapping({"/calculos"})
public class CalculosController {
    @Autowired
    CalculosServiceImpl calculosService;
    @GetMapping({"/primo/"})
    public String showResults(@RequestParam Integer numero, Model model) {
        model.addAttribute("numero", numero);
        if (numero == null) return "redirect:/primo?error";
        else {
            model.addAttribute("primo", calculosService.esPrimo(numero));
        }
        return "primo";
    }

    @GetMapping({"/primo?error", "/hipotenusa?error", "/sinRepetidos?error", "/divisores?error"})
    public String showError() {
        return "error";
    }


    @GetMapping({"/hipotenusa/{x}/{y}"})
    public String showHipotenusa(@PathVariable Integer x, @PathVariable Integer y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        if (x == null || y == null || x < 0 || y < 0) return "redirect:/hipotenusa?error";
        else {
            model.addAttribute("hipotenusa", calculosService.hipotenusa(y,x));
        }
        return "hipotenusa";
    }

    @GetMapping({"/sinRepetidos/{x}"})
    public String showSRResults(@PathVariable Integer x, Model model) {
        model.addAttribute("x", x);
        if (x == null || x < 0 || x > 100) return "redirect:/sinRepetidos?error";
        else {

                model.addAttribute("numeros", calculosService.sinRepetidos(x));
            }
            return "sinrepetidos";
    }

    @GetMapping({"/divisores/{x}"})
    public String showDivisores(@PathVariable Integer x, Model model) {
        model.addAttribute("x", x);
        if (x == null || x < 0) return "redirect:/divisores?error";
        else {
            model.addAttribute("lista", calculosService.divisores(x));
            return "divisores";
        }
    }

    @GetMapping({"/divisores/"})
    public String showDiv(@RequestParam Integer num, Model model) {
        model.addAttribute("num", num);
        if (num == null || num < 0) return "redirect:/divisores?error";
        else {
            model.addAttribute("lista", calculosService.divisores(num));
            return "divisoresQuery";
        }
    }
}


