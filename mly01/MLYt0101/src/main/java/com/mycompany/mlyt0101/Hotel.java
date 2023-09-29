/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mlyt0101;



import java.util.ArrayList;


public  class Hotel  {
 private final ArrayList<Habitacion> habitaciones;
    
    public Hotel() {
        habitaciones = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            habitaciones.add(new HabitacionLowcost(i + 1));
        }
        for(int i = 0; i < 10; i++) {
            habitaciones.add(new HabitacionDoble(i + 4));
        }
        for(int i = 0; i < 5; i++) {
            habitaciones.add(new HabitacionSuite(i + 14));
        }
    }
    
    public void checkIn(int numeroHabitacion) {
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        if(habitacion != null && !habitacion.isOcupada()) {
            habitacion.checkIn();
        }
    }
    
    public void checkOut(int numeroHabitacion) {
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        if(habitacion != null && habitacion.isOcupada()) {
            double importe = habitacion.calcularImporte();
            habitacion.checkOut();
            System.out.println("El importe a pagar es: " + importe);
        }
    }
    
    private Habitacion buscarHabitacion(int numeroHabitacion) {
        for(Habitacion habitacion : habitaciones) {
            if(habitacion.getNumero() == numeroHabitacion) {
                return habitacion;
            }
        }
        return null;
    }
    
    public void listarHabitaciones() {
        for(Habitacion habitacion : habitaciones) {
            System.out.println("Habitacion numero: " + habitacion.getNumero()  
            + ", Estado: " + (habitacion.isOcupada() ? "Ocupada" : "Libre"));
        }
    }
}
