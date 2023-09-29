/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mlyt0101;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class MLYt01e06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         Primitiva premiado = new Primitiva();
        Set<Integer> boleto = new HashSet<>();
       while (boleto.size() < 6) {
            System.out.println("Introduce un número entre 1 y 49: ");
            try {
                int num = scanner.nextInt();
                if (num < 1 || num > 49) {
                    System.out.println("El número está fuera del rango 1-49. Inténtalo de nuevo.");
                    continue;
                }
                if (!boleto.add(num)) {
                    System.out.println("El número está repetido. Inténtalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor introducido no es un número. Inténtalo de nuevo.");
                scanner.next(); 
            }
        } 
        int aciertos = premiado.comprobarBoleto(boleto);
        System.out.println("Tu boleto es el siguiente: " + boleto);
        
         if (aciertos == 0){
            System.out.println("No has hacertado ningún número");
        } else {
            if (aciertos != 1){
                if (aciertos == 6){
                    System.out.println("Has acertado todos los números.");
                }
                else{
                    System.out.println("Has acertado " + aciertos + " números");
                }
            }
            else{
                System.out.println("Has acertado un número");
            }
        }
    }
}
        
     
