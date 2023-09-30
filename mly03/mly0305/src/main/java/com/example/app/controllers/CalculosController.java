package com.example.app.controllers;

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

    @GetMapping({"/primo/"})
    public String showResults(@RequestParam Integer numero, Model model) {
        model.addAttribute("numero", numero);
        if (numero == null) return "redirect:/primo?error";
        else {
            boolean primo = true;

            for (int i = 2; i <= 1000; i++) {
                if (numero == 2) {
                    primo = true;
                    break;
                } else {
                    if (numero % 2 == 0) {
                        primo = false;
                    } else {
                        for (int j = 2; j <= numero / 2; j++) {
                            if ((numero % j) != 0) {
                                primo = true;
                            } else {
                                primo = false;
                                break;
                            }
                        }

                    }
                }

            }

            model.addAttribute("primo", primo);
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
            Double hipotenusa = Math.sqrt((Math.pow(x, 2)) + (Math.pow(y, 2)));
            model.addAttribute("hipotenusa", hipotenusa);
        }
        return "hipotenusa";
    }

    @GetMapping({"/sinRepetidos/{x}"})
    public String showSRResults(@PathVariable Integer x, Model model) {
        model.addAttribute("x", x);
        if (x == null || x < 0 || x > 100) return "redirect:/sinRepetidos?error";
        else {
            Random random = new Random();
            Set<Integer> numeros = new TreeSet<>();
            for (int i = 0; i < x; i++) {
                numeros.add(random.nextInt(100) + 1);
                model.addAttribute("numeros", numeros);
            }
            return "sinrepetidos";
        }

    }

    @GetMapping({"/divisores/{x}"})
    public String showDivisores(@PathVariable Integer x, Model model) {

        model.addAttribute("x", x);
        if (x == null || x < 0) return "redirect:/divisores?error";
        else {
            List<Integer> lista = new ArrayList<>();
            for (int i = x; i > 0; i--) {

                if (x % i == 0) {
                    lista.add(i);
                }
            }
            model.addAttribute("lista", lista);
            return "divisores";
        }


    }

    @GetMapping({"/divisores/"})
    public String showDiv(@RequestParam Integer num, Model model) {

        model.addAttribute("num", num);
        if (num == null || num < 0) return "redirect:/divisores?error";
        else {
            List<Integer> lista = new ArrayList<>();
            for (int i = num; i > 0; i--) {

                if (num % i == 0) {
                    lista.add(i);
                }
            }
            model.addAttribute("lista", lista);
            return "divisoresQuery";
        }
    }
}


