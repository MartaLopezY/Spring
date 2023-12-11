package com.example.app.controllers;


import com.example.app.entity.Movimiento;
import com.example.app.exceptions.NotFoundException;
import com.example.app.services.CuentaService;
import com.example.app.services.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RequestMapping({"/movimiento"})
    @Controller
    public class MovimientoController {

        @Autowired
        public MovimientoService movimientoService;
        @Autowired
        public CuentaService cuentaService;

        @GetMapping({"/", "/list",""})
        public String showList(@RequestParam(required = false) Integer err, Model model) {
            model.addAttribute("listaMovimiento", movimientoService.obtenerTodos());
            return "/movimiento/movimientoView";
        }
        @GetMapping("/{IBAN}")
        public String showListInMovimiento(@PathVariable String IBAN, Model model) throws NotFoundException {

        model.addAttribute("listaMovimientos", movimientoService.obtenerPorCuenta(cuentaService.obtenerPorIBAN(IBAN)));
        model.addAttribute("iban",IBAN);
        return "/movimiento/movimientoView";
    }

        @GetMapping("/nuevo/{IBAN}")
        public String showNew(@PathVariable String IBAN,Model model){
            model.addAttribute("movimientoForm",  new Movimiento(IBAN, LocalDateTime.now()));

            return "/movimiento/newMovimientoForm";
        }

        @PostMapping("/nuevo/submit")
        public String showNewSubmit(@Valid Movimiento movimientoForm, BindingResult bindingResult, Model model) throws NotFoundException {
            if (bindingResult.hasErrors()) {
                model.addAttribute("movimientoForm", new Movimiento());
                model.addAttribute("txtError", "Error en formulario");
                return "/movimiento/newMovimientoForm";
            }
            cuentaService.modificarSaldo(movimientoForm);
            return  "redirect:/movimiento/" + movimientoForm.getIBAN();
        }


    }


