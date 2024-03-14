package com.proyecto.servitrade.service;


import org.springframework.stereotype.Service;




@Service
public class MonedaServiceImpl implements MonedaService {


    public static final Long VALOR_MONEDA =  1L;
    private static final Long VALOR_SERV =  10L;


    public Long obtenerValorMoneda() {
            return VALOR_MONEDA;
        }

    public Long obtenerValorServicio() {
        return VALOR_SERV;
    }
    }

