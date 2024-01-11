package com.example.app.controllers;

import com.example.app.entity.Departamento;
import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.service.DepartamentoService;
import com.example.app.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

    public class DepartamentoController {

    @Autowired
    public DepartamentoService departamentoService;
    @GetMapping("/depto")
    public ResponseEntity<?> getList() {
        List<Departamento> listaDepartamento = departamentoService.obtenerTodos();
        if (listaDepartamento.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(listaDepartamento);
    }

    @GetMapping({ "/depto/{id}" })
    public ResponseEntity<?> getElements(@PathVariable long id) throws NotFoundException {
        Departamento departamento=departamentoService.obtenerPorId(id);
        if(departamento==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        // return ResponseEntity.status(HttpStatus.OK).body(empleado);
        return ResponseEntity.ok(departamento);
    }


    @PostMapping("/depto")
    public ResponseEntity<?> newElement(@Valid @RequestBody Departamento nuevoDepartamento) {
        Departamento departamentoañadido=departamentoService.añadir(nuevoDepartamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoañadido);
    }


    @DeleteMapping("/depto/{id}")
    public  ResponseEntity<?>  deleteElement(@PathVariable long id) throws NotFoundException {
        Departamento departamentoBusca=departamentoService.obtenerPorId(id);
        if(departamentoBusca==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        departamentoService.borrar(departamentoBusca);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}



