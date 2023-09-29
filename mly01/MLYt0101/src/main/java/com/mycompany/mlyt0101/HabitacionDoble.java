/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mlyt0101;

import java.time.LocalDateTime;
import java.time.Month;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.time.temporal.Temporal;

/**
 *
 *
 * @author marta.lopezyanez
 */
public class HabitacionDoble extends Habitacion {
    protected final double costeIni = 100.0;
    protected final double incremento = 0.2;
     public HabitacionDoble(int numero) {
        super(numero);
    }

    @Override
    public double calcularImporte() {
        double coste = (SECONDS.between((Temporal) fechaLlegada, LocalDateTime.now())) * costeIni;
        if (fechaLlegada.getMonth() == 4 || fechaLlegada.getMonth() == 7 || fechaLlegada.getMonth() == 8) {
            coste += incremento * coste;
        }
        ocupada = false;
        return coste;
    }

  

}
