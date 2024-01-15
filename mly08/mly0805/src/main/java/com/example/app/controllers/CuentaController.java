package com.example.app.controllers;


import com.example.app.dto.CuentaNuevaDto;
import com.example.app.entity.Cuenta;
import com.example.app.exceptions.CuentaConSaldo;
import com.example.app.exceptions.CuentaNotFoundException;
import com.example.app.exceptions.EmptyCuentasException;
import com.example.app.services.CuentaService;
import com.example.app.services.MovimientoService;
import com.example.app.utilities.CuentaDtoConverter;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping({"/cuenta"})
@RestController
public class CuentaController {

    @Autowired
    public CuentaService cuentaService;
    @Autowired
    public MovimientoService movimientoService;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public CuentaDtoConverter cuentaDtoConverter;

    @GetMapping({"/",""})
    public List<Cuenta> getList() {
        List<Cuenta> listaCuentas;
        try {
            listaCuentas = cuentaService.obtenerTodos();
        } catch (EmptyCuentasException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return listaCuentas;
    }

    @PostMapping("/")
    public ResponseEntity<?> newElement(@Valid @RequestBody CuentaNuevaDto cuentaNuevaDto) {
        Cuenta cuentaNueva=cuentaDtoConverter.convertDtoToCuenta(cuentaNuevaDto);
        Cuenta cuentaAgregada=cuentaService.agregar(cuentaNueva);
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaAgregada);
    }
    @PutMapping("/{IBAN}")
    public ResponseEntity<?>  EditElement(@PathVariable String IBAN) {
        Cuenta cuenta;
        try {
            cuenta = cuentaService.obtenerPorIBAN(IBAN);
            cuentaService.editar(cuenta);
            return ResponseEntity.status(HttpStatus.OK).body(cuenta);
        } catch (CuentaNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

    @DeleteMapping("/{IBAN}")
    public  ResponseEntity<?>  deleteElement(@PathVariable String IBAN) {

        try{
            cuentaService.borrar(IBAN);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (CuentaConSaldo ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

}


