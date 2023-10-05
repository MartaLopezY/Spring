package com.example.app.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class numerosServiceImpl implements  numerosService{

    Random random=new Random();
    public Set<Integer> lista=new HashSet<>();

    public Set<Integer> agregar(){
        lista.add(random.nextInt(100) +1);
        return lista;
    }
    public Set<Integer> delete(Integer id) {
        lista.remove(id);
        return lista;

    }

}
