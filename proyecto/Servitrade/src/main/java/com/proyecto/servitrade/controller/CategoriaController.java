package com.proyecto.servitrade.controller;

import com.proyecto.servitrade.entity.Categoria;
import com.proyecto.servitrade.service.CategoriaService;
import com.proyecto.servitrade.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@RequestMapping({"/categoria"})
@Controller
public class CategoriaController {

    @Autowired
    public CategoriaService categoriaService;
    @Autowired
    public ProductoService productoService;

    @GetMapping({"/", "/list"})
    public String showList(@RequestParam(required = false) Integer err, Model model) {
        model.addAttribute("listaCategoria", categoriaService.obtenerTodos());
        return "/categoria/categoriaView";
    }

    @GetMapping("/nueva")
    public String showNew(Model model) {

        model.addAttribute("categoriaForm", new Categoria());
        return "/categoria/newCategoriaForm.html";
    }

    @PostMapping("/nueva/submit")
    public String showNewSubmit(@Valid Categoria categoriaForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            model.addAttribute("categoriaForm", new Categoria());
            model.addAttribute("txtError", "Error en formulario");
            return "/categoria/newCategoriaForm.html";
        }
        categoriaService.agregar(categoriaForm);
        return "redirect:/categoria/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Categoria categoria;
        try {
            categoria = categoriaService.obtenerPorId(id);
        } catch (NotFoundException e) {
            return "redirect:/categoria/?err=1";
        }
        model.addAttribute("categoriaForm", categoria);
        return "/categoria/editCategoria";
    }


    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Categoria categoriaForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/?err=1";
        try {
            categoriaService.editar(categoriaForm);
        } catch (NotFoundException e) {
            return "redirect:/categoria/?err=1";
        }
        return "redirect:/categoria/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        try {
            if (productoService.obtenerPorCategoria(categoriaService.obtenerPorId(id)).size() == 0)
                categoriaService.borrar(id);
        } catch (NotFoundException e) {
            return "redirect:/categoria/?err=1";
        }
        return "redirect:/categoria/list";
    }


}
