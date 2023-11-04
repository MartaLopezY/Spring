package com.example.app.services;


import com.example.app.entity.Pais;
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

public class PaisesService {
    /**
     *
     */
    public static List<Pais> paises = new ArrayList<>();


    public  void cargarPaisesDesdeFichero(){

            List<String> lineas = null;
            try{
                Path path= Paths.get("paises2019.csv");
                lineas= Files.readAllLines(path, StandardCharsets.ISO_8859_1);
            }
            catch(IOException ex) {System.err.printf("%nError:%s",ex.getMessage());}
            String[] partes;
            for(String linea: lineas){
                partes=linea.split(";");
                paises.add(new Pais(partes[0], partes[1], Long.parseLong(partes[2])));
            }
    }
    public List<Pais> getPaises(){
        return paises;
    }
    public Pais getPais (String nombre){

        for (Pais pais : paises)
            if (Objects.equals(pais.getNombre(), nombre))
                return pais;
        return null;
    }


}