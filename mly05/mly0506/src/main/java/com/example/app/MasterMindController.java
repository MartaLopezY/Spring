package com.example.app;

import com.example.app.model.MasterMind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.model.FormInfo;

import javax.validation.Valid;

@Controller
@Scope("session")
public class MasterMindController {

    @Autowired
    public MasterMindService masterMindService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "indexView";
    }

    @GetMapping("/juego")
    public String showGame(Model model) {
        int intentosRestantes = MasterMind.MAX_INTENTOS - masterMindService.masterMind.getListaIntentos().size();
        model.addAttribute("intentosRestantes", intentosRestantes);
        model.addAttribute("formInfo", new FormInfo());
        model.addAttribute("listaIntentos", masterMindService.masterMind.getListaIntentos());
        model.addAttribute("estadoJuego", masterMindService.masterMind.getEstadoJuego());
        return "juegoView";
    }

    @PostMapping("/juego")
    public String newTry(@Valid FormInfo formInfo, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "se ha producido un error al introducir los datos");
            return "juegoView";
        }
        masterMindService.comprobarIntento(formInfo.getIntento(), bindingResult);
        return "redirect:/juego";

    }
    @PostMapping("/nuevoJuego")
    public String newGame(@ModelAttribute("formInfo") FormInfo formInfo) {
        int intentos = formInfo.getIntentos();
        int digitos = formInfo.getDigitos();
        masterMindService.nuevoJuego(intentos, digitos);

        return "redirect:/juego";
    }
}
