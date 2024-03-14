package com.proyecto.servitrade.service;

import com.proyecto.servitrade.entity.Provincia;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Service
public class ProvinciaServiceImpl implements ProvinciaService{
    public  List<Provincia> provincias = new ArrayList<>();


    public void cargarProvinciasDesdeFichero() {
        List<String> lineas = null;
        try {
            Path path = Paths.get("codprov.csv");
            lineas = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
        } catch (IOException ex) {
            System.err.printf("%nError:%s", ex.getMessage());
            return;
        }

        if (lineas != null) {
            String[] partes;
            for (String linea : lineas) {
                partes = linea.split(";");
                if (partes.length >= 2) {
                    provincias.add(new Provincia(Long.parseLong(partes[0]), partes[1]));
                }
            }
        }
    }
    public List<Provincia> getProvincias(){
        return provincias;
    }
    public Provincia getProvincia (String nombre){

        for (Provincia provincia : provincias)
            if (Objects.equals(provincia.getNombre(), nombre))
                return provincia;
        return null;
    }


}

