package com.example.app.controllers;

import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




    @Controller
    public class EmpleadoController {

        @Autowired
        public EmpleadoService empleadoService;
        @GetMapping({ "/", "/list" })
        public String showList(@RequestParam(required = false) Integer err, Model model) {
            model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
            return "listView";
        }
        @GetMapping("/nuevo")
        public String showNew(Model model) {

            model.addAttribute("empleadoForm", new Empleado());
            return "newFormView";
        }
        @PostMapping("/nuevo/submit")
        public String showNewSubmit(@Valid Empleado empleadoForm, BindingResult bindingResult,Model model) {
            if (bindingResult.hasErrors()){

                model.addAttribute("empleadoForm", new Empleado());
                model.addAttribute("txtError", "Error en formulario"); // otra opción es redirect /new?err=1
                return "newFormView";
            }
            empleadoService.agregar(empleadoForm);
            return "redirect:/list";
        }
        @GetMapping("/editar/{id}")
        public String showEditForm (@PathVariable long id, Model model) {
            Empleado empleado;
            try {
                empleado = empleadoService.obtenerPorId(id);
            } catch (NotFoundException e) {
                return "redirect:/?err=1";
            }
            model.addAttribute("empleadoForm", empleado);
            return "editView";
        }


        @PostMapping("/editar/{id}/submit")
        public String showEditSubmit(@PathVariable Long id, @Valid Empleado empleadoForm, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) return "redirect:/?err=1";
            try {
                empleadoService.editar(empleadoForm);
            } catch (NotFoundException e) {
                return "redirect:/?err=1";
            }
            return "redirect:/";
        }
        @GetMapping("/delete/{id}")
        public String showDelete(@PathVariable long id) {
            try {
                empleadoService.borrar(id);
            } catch (NotFoundException e) {
                return "redirect:/?err=1";
            }
            return "redirect:/list";
        }

        @GetMapping("/editEmail/{id}")
        public String showEditEmailForm(@PathVariable long id, Model model) {
            Empleado empleado;
            try {
                empleado = empleadoService.obtenerPorId(id);
            } catch (NotFoundException e) {
                return "redirect:/?err=1";
            }
            model.addAttribute("empleadoDtoForm", empleadoService.convertEmpleadoToEmpleadoDto(empleado));
            return "editEmailView";
        }

        @PostMapping("/editEmail/{id}/submit")
        public String showEditEmailSubmit(@PathVariable Long id, @Valid EmpleadoDto empleadoDtoForm, BindingResult bindingResult) {

            if (bindingResult.hasErrors()) {
                return "redirect:/?err=1";
            }
            try {
                empleadoService.editarEmail(empleadoDtoForm);
            } catch (NotFoundException e) {
                return "redirect:/?err=1";
            }
            return "redirect:/";
        }
    }


