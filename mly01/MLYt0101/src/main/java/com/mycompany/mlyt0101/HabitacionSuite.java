/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mlyt0101;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.time.temporal.Temporal;


public class HabitacionSuite extends Habitacion {
    protected  final double costeIni = 200.0;
    protected  final double descuento = 0.2;
  public HabitacionSuite(int numero) {
        super(numero);
    }
    @Override
    public double calcularImporte() {
        double coste = (SECONDS.between((Temporal) fechaLlegada, LocalDateTime.now())) * costeIni;
        if ((SECONDS.between((Temporal) fechaLlegada, LocalDateTime.now()))>10) {
            coste = (float) (costeIni-( 0.2 * coste));
        }
        ocupada = false;
        return coste;
    }

}
