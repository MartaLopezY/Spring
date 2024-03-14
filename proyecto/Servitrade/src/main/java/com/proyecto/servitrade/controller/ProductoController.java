package com.proyecto.servitrade.controller;


import com.proyecto.servitrade.entity.Categoria;
import com.proyecto.servitrade.entity.Producto;
import com.proyecto.servitrade.service.CategoriaService;
import com.proyecto.servitrade.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

@Controller
@RequestMapping("/servicio")
public class ProductoController {

    @Autowired
    public ProductoService productoService;
    @Autowired
    public CategoriaService categoriaService;



    @GetMapping("/list/{idCat}")
    public String showListInCategory(@PathVariable Long idCat, Model model) throws NotFoundException {

        model.addAttribute("listaProductos", productoService.obtenerPorCategoria(categoriaService.obtenerPorId(idCat)));
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        try {
            model.addAttribute("categoriaSeleccionada", categoriaService.obtenerPorId(idCat));
        } catch (NotFoundException e) {
            return "redirect:/categoria/?err=1";
        }
        return "/servicio/productoView";
    }

    @GetMapping({"/", "/list",""})
    public String showList(@RequestParam(required = false) Integer err, Model model) {
        model.addAttribute("listaProductos", productoService.obtenerTodos());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        model.addAttribute("categoriaSeleccionada", new Categoria(0L,"Todas"));
        return "/servicio/productoView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {

        model.addAttribute("productoForm", new Producto());
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "/servicio/newProductoForm";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Producto productoForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            model.addAttribute("productoForm", new Producto());
            model.addAttribute("txtError", "Error en formulario");
            model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
            return "/servicio/newProductoForm";
        }
        productoService.agregar(productoForm);
        return "redirect:/servicio/list";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Producto producto;
        try {
            producto = productoService.obtenerPorId(id);
        } catch (NotFoundException | ChangeSetPersister.NotFoundException e) {
            return "redirect:/servicio/?err=1";
        }
        model.addAttribute("productoForm", producto);
        model.addAttribute("listaCategorias", categoriaService.obtenerTodos());
        return "/servicio/editProducto";
    }


    @PostMapping("/editar/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Producto productoForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/producto/?err=1";
        try {
            productoService.editar(productoForm);
        } catch (NotFoundException e) {
            return "redirect:/producto/?err=1";
        }
        return "redirect:/servicio/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        try {
            productoService.borrar(id);
        } catch (NotFoundException e) {
            return "redirect:/servicio/?err=1";
        }
        return "redirect:/servicio/list";
    }


}
