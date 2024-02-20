package com.example.app.controllers;

import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleado")
    public class EmpleadoController {

        @Autowired
        public EmpleadoService empleadoService;
        @Autowired
        public DepartamentoService departamentoService;
        @Autowired
        public CategoriaService categoriaService;

    @GetMapping({ "/list/porDepto/{idDpto}" })
    public String showListDpto(@PathVariable Long idDpto, Model model) {
        model.addAttribute("listaEmpleados", empleadoService.obtenerPorDepto(departamentoService.obtenerPorId(idDpto)));
        model.addAttribute("nombreEmpleadoMax",empleadoService.obtenerEmpleadoMax());
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        model.addAttribute("deptoSeleccionado", departamentoService.obtenerPorId(idDpto));
        return "empleado/listView";
    }

        @GetMapping({ "/", "/list" })
        public String showList(@RequestParam(required = false) Integer err, Model model) {
            model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
            model.addAttribute("nombreEmpleadoMax",empleadoService.obtenerEmpleadoMax());
            model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
            model.addAttribute("deptoSeleccionado", 0);
            return "empleado/listView";
        }
        @GetMapping("/nuevo")
        public String showNew(Model model) {
            model.addAttribute("empleadoForm", new Empleado());
            model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
            model.addAttribute("listaCategorias",categoriaService.obtenerTodos());
            return "/empleado/newFormView";
        }
        @PostMapping("/nuevo/submit")
        public String showNewSubmit(@Valid Empleado empleadoForm, BindingResult bindingResult,Model model) {
            if (bindingResult.hasErrors()){

                model.addAttribute("empleadoForm", new Empleado());
                model.addAttribute("txtError", "Error en formulario");
                return "/empleado/newFormView";
            }
            empleadoService.agregar(empleadoForm);
            return "redirect:/empleado/list";
        }
        @GetMapping("/editar/{id}")
        public String showEditForm (@PathVariable long id, Model model) throws NotFoundException {
            Empleado empleado;

                empleado = empleadoService.obtenerPorId(id);

            model.addAttribute("empleadoForm", empleado);
            model.addAttribute("listaDepartamentos",departamentoService.obtenerTodos());
            model.addAttribute("listaCategorias",categoriaService.obtenerTodos());
            return "/empleado/editView";
        }
        @PostMapping("/editar/{id}/submit")
        public String showEditSubmit(@PathVariable Long id, @Valid Empleado empleadoForm, BindingResult bindingResult) throws NotFoundException {
            if (bindingResult.hasErrors()) return "redirect:/?err=1";

                empleadoService.editar(empleadoForm);

            return "redirect:/empleado/";
        }
        @GetMapping("/delete/{id}")
        public String showDelete(@PathVariable long id) {
            try {
                empleadoService.borrar(id);
            } catch (NotFoundException e) {
                return "redirect:/empleado/?err=1";
            }
            return "redirect:/empleado/list";
        }

        @GetMapping("/editEmail/{id}")
        public String showEditEmailForm(@PathVariable long id, Model model) throws NotFoundException {
            Empleado empleado;
                empleado = empleadoService.obtenerPorId(id);

            model.addAttribute("empleadoDtoForm", empleadoService.convertEmpleadoToEmpleadoDto(empleado));
            return "/empleado/editEmailView";
        }

        @PostMapping("/editEmail/{id}/submit")
        public String showEditEmailSubmit(@PathVariable Long id, @Valid EmpleadoDto empleadoDtoForm, BindingResult bindingResult) {

            if (bindingResult.hasErrors()) {
                return "redirect:/empleado/?err=1";
            }
            try {
                empleadoService.editarEmail(empleadoDtoForm);
            } catch (NotFoundException e) {
                return "redirect:/empleado/?err=1";
            }
            return "redirect:/empleado/";
        }
        @GetMapping("/listado1/{salario}")
        public String showListado1(@PathVariable Double salario, Model model) {
            List<Empleado> empleados = empleadoService.obtenerEmpleadosSalarioMayor (salario);
            model.addAttribute("tituloListado", "Empleados salario mayor que " +
                    salario.toString());
            model.addAttribute("listaEmpleados", empleados);
            return "/empleado/listadosView";
        }
        @GetMapping("/listado2")
        public String showListado2(Model model) {
            List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
            model.addAttribute("tituloListado", "Empleados salario mayor que la media:");
            model.addAttribute("listaEmpleados", empleados);
            return "/empleado/listadosView";
        }
    }


