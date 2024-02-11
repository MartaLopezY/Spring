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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/public"})
@Controller
public class MainController {
    @Autowired
    public UsuarioService usuarioService;
    @GetMapping({"", "/", "/home", "/index"})
    public  String showMain(Model model) {
        model.addAttribute("usuario",new Usuario());
        return "indexView";
    }
    @PostMapping({ "/index/submit"})
    public  String showMain(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/home";

        return "indexUserView";
    }
    @GetMapping("/contacta")
    public  String showContacta() {

        return "contactaView";
    }

    @GetMapping("/quienessomos")
    public  String showQuienesSomos() {

        return "quienes-somosView";
    }
    @GetMapping("/nuevoRegistro/{nombre}")
    public String showNew(Model model) {
        model.addAttribute("registroForm", new Usuario());
        return "registro";
    }

    @PostMapping("/nuevoRegistro/submit")
    public String showNewSubmit( @Valid Usuario registroForm,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/public/registro/nuevo";
        registroForm.setRol(Rol.valueOf("USER"));
        usuarioService.agregar(registroForm);
        return "indexView";
    }

}
