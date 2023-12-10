package com.example.app.controllers;

import com.example.app.entity.Usuario;
import com.example.app.exceptions.NotFoundException;
import com.example.app.services.UsuarioService;
import com.example.app.services.UsuarioValoracionService;
import com.example.app.services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/usuValor")
public class UsuarioValoracionController {
    @Autowired
    public UsuarioValoracionService usuarioValoracionService;
    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ValoracionService valoracionService;

    @GetMapping("/usu/{id}") // lista de valoraciones de un usuario
    public String showValsByUsu(@PathVariable long id, Model model) throws NotFoundException {
        Usuario u = usuarioService.obtenerPorId(id);
        model.addAttribute("listaUsuarioValoracion",
                usuarioValoracionService.obtenerPorUsuario(u));
        model.addAttribute("usuario", usuarioService.obtenerPorId(id));
        return "usuarioValoracion/usuListView";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteUsu(@PathVariable long id) {
        usuarioValoracionService.borrar(usuarioValoracionService.obtenerPorId(id));
        return "redirect:/";
    }

}

