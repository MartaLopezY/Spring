package com.example.app.controllers;


import com.example.app.services.CambioDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CambioDataController
{
    @Autowired
    private CambioDataService cambioDataService;
    @GetMapping("")
    public Mono<ModelAndView> showForm(Model model) {
        List<String> monedas = Arrays.asList("Euro", "Libra esterlina", "Yen", "Dolar USA");
        model.addAttribute("monedas", monedas);

        return Mono.just(new ModelAndView("indexView"));
    }
    @PostMapping("/convertir")
    @ResponseStatus(HttpStatus.OK)
    public String convertCurrency(@RequestParam("importe") Float importe,
                                  @RequestParam("origen") String origen,
                                  @RequestParam("destino") String destino,
                                  Model model) {
        Map<String, String> currencyMap = new HashMap<>();
        currencyMap.put("Euro", "EUR");
        currencyMap.put("Libra esterlina", "GBP");
        currencyMap.put("Yen", "JPY");
        currencyMap.put("Dolar USA", "USD");

        String originCode = currencyMap.get(origen);
        String destinationCode = currencyMap.get(destino);
        Float exchangeRate = cambioDataService.getExchangeRate(originCode, destinationCode).block();
        Float resultado = importe * exchangeRate;
        model.addAttribute("resultado", resultado);
        return "resultadoView";
    }
}