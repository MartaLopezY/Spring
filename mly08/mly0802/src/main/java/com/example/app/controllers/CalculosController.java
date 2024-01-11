package com.example.app.controllers;

import com.example.app.service.CalculosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping({"/calculos"})
public class CalculosController {
    @Autowired
    CalculosServiceImpl calculosService;
    @GetMapping({"/primo"})
    public ResponseEntity<?>  getResults() {

        Integer x = 17;
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("numero",  x.toString());
        mapa.put("primo",  calculosService.esPrimo(x).toString());
        return ResponseEntity.ok(mapa);
    }

    @GetMapping({"/hipotenusa"})
    public ResponseEntity<?> getHipotenusa() {
        Integer x = 10;
        Integer y = 20;
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("numeroX",  x.toString());
        mapa.put("numeroY",  y.toString());
        mapa.put("hipotenusa", calculosService.hipotenusa(y,x).toString());
        return ResponseEntity.ok(mapa);

    }

    @GetMapping({"/sinRepetidos"})
    public ResponseEntity<?> getSRResults() {
        Integer x = 15;
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("numero",  x.toString());
        mapa.put("numeros", calculosService.sinRepetidos(x).toString());
        return ResponseEntity.ok(mapa);

    }

    @GetMapping({"/divisores"})
    public ResponseEntity<?>  getDivisores() {
        Integer x = 30;
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("numero",  x.toString());
        mapa.put("lista", calculosService.divisores(x).toString());
        return ResponseEntity.ok(mapa);

    }

}


