/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mlyt0101;

import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.time.temporal.Temporal;



    public class HabitacionLowcost extends Habitacion {
 protected  final double coste = 50.0;
    HabitacionLowcost(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double calcularImporte(){     
   ocupada=false;
   return ((SECONDS.between((Temporal) fechaLlegada,LocalDateTime.now()))*coste);
   } 

}
    

