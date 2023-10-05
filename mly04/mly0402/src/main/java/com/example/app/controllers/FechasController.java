package com.example.app.controllers;

import com.example.app.service.FechasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;


@Controller
@RequestMapping({"/fechas"})
public class FechasController {
    @Autowired
    FechasServiceImpl fechasService;
    @GetMapping({"/"})
    public String showDays(Model model) {

        model.addAttribute("x", LocalDate.now());
        model.addAttribute("dias", fechasService.daysForYear(LocalDate.now()));
        return "daysForYear";
    }
    @GetMapping({"/{x}"})
    public String showD(@PathVariable String x, Model model) {

        model.addAttribute("x", LocalDate.parse(x));
        model.addAttribute("dias", fechasService.daysForYear(LocalDate.parse(x)));
        return "daysForYear";
    }
    @GetMapping({"/{x}/{y}"})
    public String showDaysDates(@PathVariable String x,@PathVariable String y, Model model) {

        model.addAttribute("x", LocalDate.parse(x));
        model.addAttribute("y", LocalDate.parse(y));
        model.addAttribute("dias", fechasService.diasFechas(LocalDate.parse(x),LocalDate.parse(y)));
        return "diasFechas";
    }
    @GetMapping({"/bisiesto/{x}"})
    public String showBisiesto(@PathVariable String x, Model model) {

        model.addAttribute("x", LocalDate.parse(x).getYear());
        model.addAttribute("bisiesto", fechasService.esBisiesto(LocalDate.parse(x)));
        return "esBisiesto";
    }
    @GetMapping({"/bisiesto/{x}/{y}"})
    public String showBis(@PathVariable String x,@PathVariable String y, Model model) {

        model.addAttribute("x", LocalDate.parse(x).getYear());
        model.addAttribute("y", LocalDate.parse(y).getYear());
        model.addAttribute("num", fechasService.numerosBisiestos(LocalDate.parse(x),LocalDate.parse(y)));
        return "numBisiestos";
    }
}


