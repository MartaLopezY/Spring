package com.example.app.service;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public interface CalculosService {

    public Boolean esPrimo(Integer numero);

    public Double hipotenusa(Integer a,Integer b);

    public Set<Integer> sinRepetidos(Integer num);

public List<Integer> divisores(Integer num);
}
