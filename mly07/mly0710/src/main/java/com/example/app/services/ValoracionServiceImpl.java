package com.example.app.services;


import com.example.app.entity.Valoracion;
import com.example.app.repositories.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValoracionServiceImpl implements ValoracionService {

    @Autowired
    ValoracionRepository valoracionRepository;

    public Valoracion agregar(Valoracion valoracion) { return valoracionRepository.save(valoracion);}

    public List<Valoracion> obtenerTodos() {
        return valoracionRepository.findAll();
    }

    public Valoracion obtenerPorId(Long id)   {return valoracionRepository.findById(id).orElse(null);}

    public Valoracion editar(Valoracion valoracion) { return valoracionRepository.save(valoracion);}

    public void borrar(Long id)  {valoracionRepository.deleteById(id);}
}

