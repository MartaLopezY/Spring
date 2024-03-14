package com.proyecto.servitrade.service;


import org.springframework.stereotype.Service;
;

import java.util.List;


@Service
public interface MonedaService {


    Long obtenerValorMoneda();
    Long obtenerValorServicio();
}
