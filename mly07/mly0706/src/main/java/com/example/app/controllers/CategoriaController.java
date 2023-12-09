package com.example.app.controllers;

import com.example.app.entity.Categoria;
import com.example.app.service.CategoriaService;
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
@RequestMapping("/categoria")
    public class CategoriaController {

    @Autowired
    public CategoriaService categoriaService;


    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "categoria/listView";
    }
    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("categoriaForm", new Categoria());
        return "categoria/newFormView";
    }
    @PostMapping("/new/submit")
    public String showNewSubmit( @Valid Categoria categoriaForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/categoria/new";
        categoriaService.agregar(categoriaForm);
        return "redirect:/categoria/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {

        categoriaService.borrar(categoriaService.obtenerPorId(id));

        return "redirect:/categoria/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Categoria categoria = categoriaService.obtenerPorId(id);
        if (categoria != null) {
            model.addAttribute("categoriaForm", categoria);
            return "categoria/editFormView";
        } else {
            return "redirect:/categoria/list";
        }
    }
    @PostMapping("/edit/submit")
    public String showEditSubmit( @Valid Categoria categoriaForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            categoriaService.editar(categoriaForm);
        return "redirect:/categoria/list";
    }
}



