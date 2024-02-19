package com.example.app.controllers;

import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

    @RestController
    public class EmpleadoController {

        @Autowired
        public EmpleadoService empleadoService;
        @GetMapping({ "/empleado" })
        public ResponseEntity<?> getElements( ) {
           List<Empleado> listaEmpleados= empleadoService.obtenerTodos();
          // return ResponseEntity.status(HttpStatus.OK).body(listaEmpleados);
            return ResponseEntity.ok(listaEmpleados);
        }
       @GetMapping({ "/empleado/{id}" })
        public ResponseEntity<?> getOneElement(@PathVariable long id) throws NotFoundException {
        Empleado empleado=empleadoService.obtenerPorId(id);
        if(empleado==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        // return ResponseEntity.status(HttpStatus.OK).body(empleado);
        return ResponseEntity.ok(empleado);
        }

        @PostMapping("/empleado")
        public ResponseEntity<?> newElement(@Valid @RequestBody Empleado nuevoEmpleado) {
        Empleado empleadoañadido=empleadoService.agregar(nuevoEmpleado);
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadoañadido);
        }

        @PutMapping("/empleado/{id}")
        public ResponseEntity<?>  editElement (@PathVariable long id,  @RequestBody Empleado empleado ) throws NotFoundException {
            Empleado empleadoBusca=empleadoService.obtenerPorId(id);
            if(empleadoBusca==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            Empleado empleadoEditado=empleadoService.editar(empleado);
                return ResponseEntity.status(HttpStatus.OK).body(empleadoEditado);
        }
        @DeleteMapping("/empleado/{id}")
        public  ResponseEntity<?>  deleteElement(@PathVariable long id) throws NotFoundException {
            Empleado empleadoBusca=empleadoService.obtenerPorId(id);
            if(empleadoBusca==null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            empleadoService.borrar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }


