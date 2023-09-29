/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mlyt0101;


import java.util.Date;

/**
 *
 *
 * @author marta.lopezyanez
 */
public abstract class Habitacion  {
   protected int numero;
    protected boolean ocupada;
    protected Date fechaLlegada;

    public Habitacion(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public void checkIn() {
        this.ocupada = true;
        this.fechaLlegada = new Date();
    }

    public void checkOut() {
        this.ocupada = false;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public int getNumero() {
        return numero;
    }

    public abstract double calcularImporte();
}
