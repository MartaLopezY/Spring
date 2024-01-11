package com.example.app.controllers;

import com.example.app.dto.EmpleadoNuevoDto;
import com.example.app.entity.Empleado;
import com.example.app.entity.EmpleadoDto;
import com.example.app.exceptions.NotFoundException;
import com.example.app.service.DepartamentoService;
import com.example.app.service.EmpleadoService;
import com.example.app.utilities.EmpleadoDtoConverter;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
    public class EmpleadoController {
        @Autowired
        public ModelMapper modelMapper;
        @Autowired
        public EmpleadoService empleadoService;
        @Autowired
        public DepartamentoService departamentoService;
        @Autowired
        public EmpleadoDtoConverter empleadoDtoConverter;

        @GetMapping({ "/empleado" })
        public ResponseEntity<?> getList() {
            List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
            if (listaEmpleados.isEmpty())
                return ResponseEntity.notFound().build(); // cod 404
            else {
                List<EmpleadoDto> listaEmpleadoDto = new ArrayList<>();
                for (Empleado e : listaEmpleados)
                    listaEmpleadoDto.add(modelMapper.map(e, EmpleadoDto.class));
                return ResponseEntity.ok(listaEmpleadoDto); // cod 200
            }
        }
        @GetMapping({ "/empleado/{id}" })
        public ResponseEntity<?> getElements(@PathVariable long id) throws NotFoundException {
        Empleado empleado=empleadoService.obtenerPorId(id);
        if(empleado==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        // return ResponseEntity.status(HttpStatus.OK).body(empleado);
        return ResponseEntity.ok(empleado);
        }

    @PostMapping("/empleado")
    public ResponseEntity<?> newElement(@RequestBody EmpleadoNuevoDto empleadoNuevoDto) {
        Empleado empleado = empleadoDtoConverter.convertDtoToEmpleado(empleadoNuevoDto);
        Empleado empleadoSaved = empleadoService.agregar(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSaved);
    }
    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@RequestBody EmpleadoNuevoDto editEmpleado, @PathVariable Long id) throws NotFoundException {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
            empleado = empleadoDtoConverter.convertDtoToEmpleado(editEmpleado, id);
            Empleado empleadoSaved = empleadoService.editar(empleado);
            return ResponseEntity.ok(empleadoSaved); // cod 200
        }
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


