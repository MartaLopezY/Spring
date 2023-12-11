package com.example.app.controllers;


import com.example.app.entity.Cuenta;
import com.example.app.exceptions.NotFoundException;
import com.example.app.services.MovimientoService;
import com.example.app.services.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping({"/cuenta"})
@Controller
public class CuentaController {

    @Autowired
    public CuentaService cuentaService;
    @Autowired
    public MovimientoService movimientoService;

    @GetMapping({"/", "/list",""})
    public String showList(@RequestParam(required = false) Integer err, Model model) {
        model.addAttribute("listaCuentas", cuentaService.obtenerTodos());
        model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
        model.addAttribute("movimientoSeleccionado", "Todas");
        return "/cuenta/cuentaView";
    }

    @GetMapping("/list/{idMov}")
    public String showListInMovimiento(@PathVariable Long idMov, Model model){

        model.addAttribute("listaCuentas", cuentaService.findByMovimiento(idMov));
        model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
        try {
            model.addAttribute("movimientoSeleccionado", movimientoService.obtenerPorId(idMov));
        } catch (NotFoundException e) {
            model.addAttribute("txtError", "No se encuentra los movimientos");
            return "redirect:/movimiento/?err=1";
        }
        return "/cuenta/cuentaView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("cuentaForm", new Cuenta());
        model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
        return "/cuenta/newCuentaForm";
    }

    @PostMapping("/nuevo/submit")
    public String showNewSubmit(@Valid Cuenta cuentaForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cuentaForm", new Cuenta());
            model.addAttribute("txtError", "No se admiten ingresos de más de 1000 euros ni retiradas de más de 300 euros.");
            model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
            return "/cuenta/newCuentaForm";
        }
        cuentaService.agregar(cuentaForm);
        return "redirect:/cuenta/list";
    }

    @GetMapping("/editar/{IBAN}")
    public String showEditForm(@PathVariable String IBAN, Model model) {
        Cuenta cuenta;
        try {
            cuenta = cuentaService.obtenerPorIBAN(IBAN);
        } catch (NotFoundException e) {
            model.addAttribute("txtError", "No existe la cuenta con ese IBAN");
            return "redirect:/cuenta/?err=1";
        }
        model.addAttribute("cuentaForm", cuenta);
        model.addAttribute("listaMovimientos", movimientoService.obtenerTodos());
        return "/cuenta/editCuenta";
    }

    @PostMapping("/editar/{IBAN}/submit")
    public String showEditSubmit(@PathVariable String IBAN, @Valid Cuenta cuentaForm,Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            model.addAttribute("txtError", "Error al editar la cuenta");
            return "redirect:/cuenta/?err=1";}
            cuentaService.editar(cuentaForm);

        return "redirect:/cuenta/";
    }

    @GetMapping("/delete/{IBAN}")
    public String showDelete(@PathVariable String IBAN,Model model) {

           cuentaService.borrar(IBAN);
           return "redirect:/cuenta/list";

    }
}


