package com.example.app.controllers;


import com.example.app.entity.Valoracion;
import com.example.app.services.ValoracionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/valoracion")
    public class ValoracionController {

    @Autowired
    public ValoracionService valoracionService;
    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaValoraciones", valoracionService.obtenerTodos());
        return "valoracion/listView";
    }
    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("valoracionForm", new Valoracion());
        return "valoracion/newFormView";
    }
    @PostMapping("/new/submit")
    public String showNewSubmit( @Valid Valoracion valoracionForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/valoracion/new";
        valoracionService.agregar(valoracionForm);
        return "redirect:/valoracion/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Long id) {

        valoracionService.borrar(valoracionService.obtenerPorId(id).getId());

        return "redirect:/valoracion/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Valoracion valoracion = valoracionService.obtenerPorId(id);
        if (valoracion != null) {
            model.addAttribute("valoracionForm", valoracion);
            return "valoracion/editFormView";
        } else {
            return "redirect:/valoracion/list";
        }
    }
    @PostMapping("/edit/submit")
    public String showEditSubmit( @Valid Valoracion valoracionForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            valoracionService.editar(valoracionForm);
        return "redirect:/valoracion/list";
    }
}



