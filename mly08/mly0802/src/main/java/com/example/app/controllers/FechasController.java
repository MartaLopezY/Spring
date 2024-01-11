package com.example.app.controllers;

import com.example.app.service.FechasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping({"/fechas"})
public class FechasController {
    @Autowired
    FechasServiceImpl fechasService;

    @GetMapping({"/now"})
    public ResponseEntity<?>  getDays() {
        LocalDate x=LocalDate.now();
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("fecha", x.toString());
        mapa.put("dias", fechasService.daysForYear(x).toString());
        return ResponseEntity.ok(mapa);
    }

    @GetMapping({"/entreFechas"})
    public ResponseEntity<?>  getDaysDates() {
        LocalDate x = LocalDate.parse("2020-10-02");
        LocalDate y = LocalDate.parse("2020-12-23");
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("fecha1", x.toString());
        mapa.put("fecha2", y.toString());
        mapa.put("dias",  fechasService.diasFechas(x,y).toString());
        return ResponseEntity.ok(mapa);

    }
    @GetMapping({"/bisiesto"})
    public ResponseEntity<?>  getBisiesto() {
        LocalDate x = LocalDate.parse("2024-10-02");
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("fecha", x.toString());
        mapa.put("bisiesto", fechasService.esBisiesto(x).toString());
        return ResponseEntity.ok(mapa);
    }

    @GetMapping({"/bisiestoEntreFechas"})
    public ResponseEntity<?>  getBis() {
        LocalDate x = LocalDate.parse("2000-10-02");
        LocalDate y = LocalDate.parse("2020-12-23");
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("fecha1", x.toString());
        mapa.put("fecha2", y.toString());
        mapa.put("bisiesto",  fechasService.numerosBisiestos(x,y).toString());
        return ResponseEntity.ok(mapa);

    }
}


