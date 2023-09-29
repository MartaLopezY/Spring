/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mlyt0101;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * 18/1/2023
 *
 * @author marta.lopezyanez
 */
public class Persona {

    private String nombre;
    private String dni;
    private int edad;
 
   

    Persona(String n, String d, int e) {
        nombre = n;
        dni = d;
        edad = e;
       
    }
    public String getNombre() {

        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }
     public String getDni() {

        return dni;
    }

    public void setDni(String d) {
        dni = d;
    }
      public int getEdad() {

        return edad;
    }

    public void setEdad(int e) {
        edad = e;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.dni != other.dni) {
            return false;
        }
        if (this.nombre.toUpperCase().equals(other.nombre.toUpperCase())) {
            return false;
        }

        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    
    @Override
    public String toString() {
        return "Persona: " + "nombre=" + nombre + ", dni=" + dni + ", edad=" + edad;
    }
    
    

}
