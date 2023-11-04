package com.example.app.controllers;

import com.example.app.entity.Paciente;
import com.example.app.entity.PacienteDTO;
import com.example.app.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacienteController {
    @Autowired
    public PacienteService pacienteService;

    @GetMapping({"/","/home"})
    public String showList (Model model){
        model.addAttribute("listaPacientes",pacienteService.findAll());
        model.addAttribute("factura",0);
        return "pacientesList";
    }
    @GetMapping("/newPaciente")
    public String showNew (Model model){
        model.addAttribute("newPaciente",new PacienteDTO());
        return "pacienteNewView";
    }
    @PostMapping("/newPaciente/submit")
    public String showNewSubmit(@Valid PacienteDTO newPacienteDTO, BindingResult bindingResult){

        if (!bindingResult.hasErrors()) {
            Paciente newPaciente = pacienteService.buildPacientefromDTO(newPacienteDTO);
            pacienteService.add(newPaciente);
        }
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String showDelete (Model model){
        Paciente paciente=pacienteService.getFirst();
        double factura=0;
        if(paciente != null){
            factura=pacienteService.facturar(paciente);
            pacienteService.deleteFirst();
        }
        model.addAttribute("listaPacientes",pacienteService.findAll());
        model.addAttribute("factura",factura);
        return "pacientesList";
    }
}
