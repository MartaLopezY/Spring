package com.proyecto.servitrade.service;

import com.proyecto.servitrade.entity.Provincia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinciaService {

    void cargarProvinciasDesdeFichero();
    List<Provincia> getProvincias();
    Provincia getProvincia (String nombre);
}

