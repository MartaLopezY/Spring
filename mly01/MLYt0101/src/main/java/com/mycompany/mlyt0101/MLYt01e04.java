/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.mlyt0101;


import java.util.Scanner;


public class MLYt01e04 {

    

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        float importe = 0;
        Hotel hotel = new Hotel();
        do {
            int opcion = pintarMenu();
            switch (opcion) {
                case 1 -> {
                    System.out.println("\tElegiste opción 1");
                    System.out.println("Selecciona el numero de habitacion: 1->18");
                    int numero = Integer.parseInt(teclado.nextLine());
                     hotel.checkIn(numero);
                }
                case 2 -> {
                    System.out.println("\tElegiste opción 2");
                    System.out.println("Selecciona el numero de habitacion: 1->18");
                    int numero = Integer.parseInt(teclado.nextLine());
                    hotel.checkOut(numero);
                    
                }
                case 3 -> {
                    System.out.println("\tElegiste opción 3");
                    System.out.println("\n Consultar habitaciones disponibles:");
                    hotel.listarHabitaciones();
                    break;
                }
                case 0 ->
                    salir = true;
                default ->
                    System.out.println("Opción incorrecta");
            }
        } while (!salir);

    }

    private static int pintarMenu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("Elija una opción:");
        System.out.println("1 Hacer check-in");
        System.out.println("2 Hacer check-out");
        System.out.println("3 Consultar habitaciones disponibles");
        System.out.println("0 Salir del programa");
        try {                  //si introduce un valor no entero haría return 999
            return Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            return 999;
        }
    }

}
