package com.example.app.controllers;


import com.example.app.entity.Rol;
import com.example.app.entity.Usuario;
import com.example.app.services.UsuarioService;
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
@RequestMapping("/usuario")
    public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;
    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaValoraciones", usuarioService.obtenerTodos());
        return "usuario/listView";
    }
    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("usuarioForm", new Usuario());
        model.addAttribute("rol",Rol.values());
        return "usuario/newFormView";
    }
    @PostMapping("/new/submit")
    public String showNewSubmit( @Valid Usuario usuarioForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/usuario/new";
        usuarioService.agregar(usuarioForm);
        return "redirect:/usuario/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Long id) {

        usuarioService.borrar(usuarioService.obtenerPorId(id).getId());

        return "redirect:/usuario/list";
    }
    @GetMapping("/edit")
    public String showEditForm(Model model) {
        String nombreUsuario = usuarioService.obtenerUsuarioConectado();
        Usuario usuario = usuarioService.obtenerPorNombre(nombreUsuario);
        if (usuario != null) {
            model.addAttribute("usuarioForm", usuario);
            model.addAttribute("rol",Rol.values());
            return "usuario/editFormView";
        } else {
            return "redirect:/usuario/list";
        }
    }
    @PostMapping("/edit/submit")
    public String showEditSubmit( @Valid Usuario usuarioForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            usuarioService.editar(usuarioForm);
        return "redirect:/usuario/list";
    }
    @GetMapping("/editPass")
    public String showEditPassForm(Model model) {
        String nombreUsuario = usuarioService.obtenerUsuarioConectado();
        Usuario usuario = usuarioService.obtenerPorNombre(nombreUsuario);
        if (usuario != null) {
            model.addAttribute("usuarioForm", usuario);
            return "usuario/editPassFormView";
        } else {
            return "redirect:/usuario/list";
        }
    }
    @PostMapping("/editPass/submit")
    public String showEditPassSubmit( @Valid Usuario usuarioForm, BindingResult bindingResult) {

        if (!bindingResult.hasErrors())
            usuarioService.editar(usuarioForm);
        return "redirect:/usuario/list";
    }
}



