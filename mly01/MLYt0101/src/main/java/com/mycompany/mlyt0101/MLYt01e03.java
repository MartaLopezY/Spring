/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mlyt0101;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OWNER
 */
public class MLYt01e03 {

    public static void main(String[] args) {
       List<Persona> lista = new ArrayList<>();
        lista.add(new Persona( "Maria","98745632V", 23));
        lista.add(new Persona("Carlos","12345678S", 44));
        lista.add(new Persona("Laura","13456798C", 25));
        lista.add(new Persona("Pepe","56412389F", 33));
        lista.add(new Persona( "Ana","45618792G", 14));

        System.out.println("Edad mayor: " + EdadMax(lista));      
        System.out.println("Edad media: "+ EdadMedia(lista));
        System.out.println("Nombre mayor: "+ NombreMayor(lista));
        System.out.println("Persona mayor: "+ PersonaMayor(lista));
        System.out.println("Persona mayores edad: "+ MayoresEdad(lista));
        System.out.println("Persona mayores que media: "+ PersonasMayoresMedia(lista));
        
    }

    private static Integer EdadMax(List<Persona> personas) {
        int edadMax = 0;
        for (Persona persona : personas) {
            if (persona.getEdad() > edadMax)
                edadMax = persona.getEdad();
        }
        return edadMax;
    }

    private static float EdadMedia(List<Persona> personas) {
        int sumaEdades = 0;
        for (Persona persona : personas)
            sumaEdades += persona.getEdad();
        if (personas.isEmpty())
            return 0;
        return  sumaEdades / personas.size();
    }

    private static String NombreMayor(List<Persona> personas) {
        
        int edadMax = 0;
        String nombreMax = "";

        for (Persona persona : personas) {
            if (persona.getEdad() > edadMax) {
                edadMax = persona.getEdad();
                nombreMax = persona.getNombre();
            }
        }
        return nombreMax;
    }

    private static Persona PersonaMayor(List<Persona> personas) {
        Persona personaMax = personas.get(0);

        for (Persona persona : personas) {
            if (persona.getEdad() > personaMax.getEdad())
                personaMax = persona;
        }
        return personaMax;
    }

   
    private static List<Persona> MayoresEdad(List<Persona> personas) {
       
        List<Persona> listaMayores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getEdad() >= 18)
                listaMayores.add(new Persona(persona.getNombre(), persona.getDni(),persona.getEdad()));
        }
        return listaMayores;
    }

    private static List<Persona> PersonasMayoresMedia(List<Persona> personas) {
        List<Persona> listaMayores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getEdad() > EdadMedia(personas))
                listaMayores.add(new Persona(persona.getNombre(), persona.getDni(),persona.getEdad()));
        }
        return listaMayores;
    }

}
