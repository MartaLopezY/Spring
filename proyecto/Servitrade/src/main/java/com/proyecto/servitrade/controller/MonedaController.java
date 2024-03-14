package com.proyecto.servitrade.controller;


import com.proyecto.servitrade.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moneda")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    @GetMapping("/valor")
    public Long obtenerValorMoneda() {
        return monedaService.obtenerValorMoneda();
    }
}
