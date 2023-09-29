/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mlyt0101;


import java.util.Scanner;
import java.util.TreeMap;

public class MLYt01e07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce una cadena");
        String cadena = scanner.nextLine().toLowerCase();

        TreeMap<Character, Integer> contMap = new TreeMap<>();
        for (int i = 0; i < cadena.length(); i++) {
            char ch = cadena.charAt(i);
            if (Character.isLetter(ch)) {
                contMap.put(ch, contMap.getOrDefault(ch, 0) + 1);
            }
        }

        System.out.println("A continuación verás las letras de tu cadena ordenadas alfabéticamente y el número de veces que se han repetido");
        System.out.println(contMap);
    
    }
}
