package com.example.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaEmpleados", empleadoService.obtenerTodos());
        return "listView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("empleadoForm", new Empleado());
        return "newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("empleadoForm") Empleado nuevoEmpleado,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "newFormView";
        }
        nuevoEmpleado = empleadoService.añadir(nuevoEmpleado);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado != null) {
            model.addAttribute("empleadoForm", empleado);
            return "editFormView";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(@Valid @ModelAttribute("empleadoForm") Empleado empleado,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "editFormView";
        }
        empleadoService.editar(empleado);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        empleadoService.borrar(id);
        return "redirect:/list";
    }

    @GetMapping("/listado1/{salario}")
    public String showListado1(@PathVariable Double salario, Model model) {
        List<Empleado> empleados = empleadoService.obtenerPorSalarioMayor(salario);
        model.addAttribute("tituloListado", "Empleados salario mayor que" + salario.toString());
        model.addAttribute("listaEmpleados", empleados);
        return "listadosView";
    }

    @GetMapping("/listado2")
    public String showListado2(Model model) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
        model.addAttribute("tituloListado", "Empleados salario mayor que la media");
        model.addAttribute("listaEmpleados", empleados);
        return "listadosView";
    }
}
