
package com.mycompany.mlyt0101;

import java.util.ArrayList;
import java.util.Scanner;

public class MLYt01e05 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<DispositivoDomotico> dispositivos = new ArrayList<>();
            dispositivos.add(new Termostato());
            dispositivos.add(new Ascensor());
            dispositivos.add(new Radio());
            
            int opcion = -1;
            while (opcion != 0) {
                System.out.println("El estado de los dispositivos es el siguiente:");
                for (int i = 0; i < dispositivos.size(); i++) {
                    System.out.println("- " + i + ": " + dispositivos.get(i).verEstado());
                }
                
                System.out.println("\n Elige una operación:");
                System.out.println("0: Salir");
                System.out.println("1: Subir un dispositivo");
                System.out.println("2: Bajar un dispositivo");
                System.out.println("3: Resetear un dispositivo");
                System.out.println("4: Revisar termostato");
                
                opcion = scanner.nextInt();
                if (opcion == 0) {
                    continue;
                }
                
                System.out.println("Elige un dispositivo:");
                int numeroDispositivo = scanner.nextInt();
                if (numeroDispositivo < 0 || numeroDispositivo >= dispositivos.size()) {
                    System.out.println("El número escrito no es válido, no se corresponde a ningún dispositivo \n");
                    continue;
                }
                
                DispositivoDomotico dispositivo = dispositivos.get(numeroDispositivo);
                switch (opcion) {
                    case 1 -> dispositivo.subir();
                    case 2 -> dispositivo.bajar();
                    case 3 -> dispositivo.reset();
                    case 4 -> {
                        if (dispositivo instanceof Termostato termostato) {
                            termostato.revisar();
                        } else {
                            System.out.println("El dispositivo elegido no es un termostato, no se puede revisar \n");
                        }
                    }
                }
            }
        }
    }
}
