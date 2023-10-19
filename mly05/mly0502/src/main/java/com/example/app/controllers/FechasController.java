package com.example.app.controllers;

import com.example.app.entity.Fecha;
import com.example.app.service.FechasServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
@RequestMapping({"/fechas"})
public class FechasController {
    @Autowired
    FechasServiceImpl fechasService;
    @GetMapping({""})
    public String showDays(Model model) {

        model.addAttribute("Fecha", new Fecha());
        return "fechas";
    }

    @PostMapping({"/?error"})
    public String showError() {
        return "error";
    }

    @PostMapping({"/submit"})
    public String showDatos(Model model, @Valid Fecha fecha, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "redirect:/?error";
        if(!fecha.getTipo()){
        model.addAttribute("x", LocalDate.parse(fecha.getFecha1()).getYear());
        model.addAttribute("y",LocalDate.parse(fecha.getFecha2()).getYear());
        model.addAttribute("num", fechasService.numerosBisiestos(LocalDate.parse(fecha.getFecha1()),LocalDate.parse(fecha.getFecha2())));
        return "numBisiestos";
        }
        model.addAttribute("x",  LocalDate.parse(fecha.getFecha1()));
        model.addAttribute("y",  LocalDate.parse(fecha.getFecha2()));
        model.addAttribute("dias", fechasService.diasFechas(LocalDate.parse(fecha.getFecha1()),LocalDate.parse(fecha.getFecha2())));
          return "diasFechas";

    }
}


