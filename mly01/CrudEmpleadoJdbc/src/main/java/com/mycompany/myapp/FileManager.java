package com.mycompany.myapp;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

   public static ArrayList<Empleado> leerFichero() {
ArrayList<Empleado> resultado=new ArrayList<>();
List<String> lineas=null;
try{
    Path path= Paths.get("archivos"+File.separator+"empleados.csv");
    lineas=Files.readAllLines(path,StandardCharsets.ISO_8859_1);
}
catch(IOException ex) {System.err.printf("%nError:%s",ex.getMessage());}
    String[] partes;
    for(String linea: lineas){
        partes=linea.split(",");
        resultado.add(new Empleado(Long.parseLong(partes[0]),
        partes[1],
        Double.parseDouble(partes[2])));
    }
    return resultado;
}
}