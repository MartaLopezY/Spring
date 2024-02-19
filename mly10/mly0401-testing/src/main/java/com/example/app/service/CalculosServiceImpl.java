package com.example.app.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalculosServiceImpl implements CalculosService{
    public Boolean esPrimo(Integer numero) throws RuntimeException {
        boolean x = true;
        if(numero<0) throw new RuntimeException("número invalido");
        for (int i = 2; i <= 1000; i++) {
            if (numero == 2) {
                x = true;
                break;
            } else {
                if (numero % 2 == 0) {
                    x = false;
                } else {
                    for (int j = 2; j <= numero / 2; j++) {
                        if ((numero % j) != 0) {
                            x = true;
                        } else {
                            x = false;
                            break;
                        }
                    }

                }
            }
        }
        return x;
    }

    public Double hipotenusa(Integer a,Integer b) {
        return (Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2))));
    }

    public Set<Integer> sinRepetidos(Integer num) {
    Random random = new Random();
    Set<Integer> numeros = new TreeSet<>();
    for (int i = 0; i < num; i++) {
        numeros.add(random.nextInt(100) + 1);
    }
    return numeros;
}
    public List<Integer> divisores(Integer num){
        List<Integer> lista = new ArrayList<>();
        for (int i = num; i > 0; i--) {
            if (num % i == 0) {
                lista.add(i);
            }
        }
        return lista;

    }
}
