package com.example.app.controllers;

import com.example.app.entity.Empleado;
import com.example.app.exceptions.EmpleadoNotFoundException;
import com.example.app.exceptions.EmptyEmpleadosException;
import com.example.app.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
    public class EmpleadoController {

    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public List<Empleado> getList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        return listaEmpleados;
    }
        @GetMapping("/empleado/{id}")
        public Empleado getOneElement(@PathVariable Long id) {
        return empleadoService.obtenerPorId(id);
        }

        @PostMapping("/empleado")
        public ResponseEntity<?> newElement(@Valid @RequestBody Empleado nuevoEmpleado) {
        Empleado empleadoañadido=empleadoService.agregar(nuevoEmpleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadoañadido);
        }

        @PutMapping("/empleado/{id}")
        public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Empleado empleado ) {
            Empleado empleadoBusca=empleadoService.obtenerPorId(id);
            if(empleadoBusca==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            Empleado empleadoEditado=empleadoService.editar(empleado);
                return ResponseEntity.status(HttpStatus.OK).body(empleadoEditado);
        }

        @DeleteMapping("/empleado/{id}")
        public  ResponseEntity<?>  deleteElement(@PathVariable long id){
            Empleado empleadoBusca=empleadoService.obtenerPorId(id);
            if(empleadoBusca==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            empleadoService.borrar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }


