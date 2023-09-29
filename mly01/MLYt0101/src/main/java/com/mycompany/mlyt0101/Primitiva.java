/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mlyt0101;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


public class Primitiva {

    private final Set<Integer> numeros;
    public Primitiva() {
        numeros = new TreeSet<>();
        Random rand = new Random();
        while (numeros.size() < 6) {
            int num = rand.nextInt(49) + 1;
            numeros.add(num);
        }
    }
   

    public int comprobarBoleto(Set<Integer> boleto) {

     Set<Integer> aciertos = new HashSet<>(numeros);
        aciertos.retainAll(boleto);
        return aciertos.size();
    }
 @Override
    public String toString() {
        return numeros.toString();
    }
 
}
