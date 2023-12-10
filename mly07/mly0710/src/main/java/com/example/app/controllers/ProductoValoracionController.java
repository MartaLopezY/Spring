package com.example.app.controllers;

import com.example.app.entity.Producto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.services.ProductoService;
import com.example.app.services.ProductoValoracionService;
import com.example.app.services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/prodVal")
public class ProductoValoracionController {
    @Autowired
    public ProductoValoracionService productoValoracionService;
    @Autowired
    public ProductoService productoService;
    @Autowired
    public ValoracionService valoracionService;

    @GetMapping("/prod/{id}")
    public String showProdsByVal(@PathVariable Long id, Model model) throws NotFoundException {
        Producto p = productoService.obtenerPorId(id);
        model.addAttribute("listaProductoValoracion",
                productoValoracionService.obtenerPorProducto(p));
        model.addAttribute("producto", productoService.obtenerPorId(id));
        return "productoValoracion/prodListView";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteEmpl(@PathVariable Long id) {
        productoValoracionService.borrar(productoValoracionService.obtenerPorId(id));
        return "redirect:/";
    }

}

