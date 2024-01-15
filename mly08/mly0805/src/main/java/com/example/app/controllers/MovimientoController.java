package com.example.app.controllers;


import com.example.app.dto.MovimientoNuevoDto;
import com.example.app.entity.Movimiento;
import com.example.app.exceptions.EmptyMovimientosException;
import com.example.app.exceptions.MovimientoImporteIncorrecto;
import com.example.app.services.CuentaService;
import com.example.app.services.MovimientoService;
import com.example.app.utilities.MovimientoDtoConverter;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RequestMapping({"/movimiento"})
    @RestController
    public class MovimientoController {

        @Autowired
        public MovimientoService movimientoService;
        @Autowired
        public CuentaService cuentaService;
        @Autowired
        public ModelMapper modelMapper;
        @Autowired
        public MovimientoDtoConverter movimientoDtoConverter;
    @GetMapping("/{IBAN}")
    public List<Movimiento> getList(@PathVariable String IBAN) {
        List<Movimiento> listaMovimientos;
        try {
            listaMovimientos =  movimientoService.obtenerPorCuenta(cuentaService.obtenerPorIBAN(IBAN));
        } catch (EmptyMovimientosException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return listaMovimientos;
    }

    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody MovimientoNuevoDto movimientoNuevoDto) {
        Movimiento movimiento= movimientoDtoConverter.convertDtoToMovimiento(movimientoNuevoDto);
        Movimiento nuevoMovimiento= movimientoService.agregar(movimiento);
        try {
            cuentaService.modificarSaldo(nuevoMovimiento);
        } catch (MovimientoImporteIncorrecto ex){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMovimiento);
    }


    }


