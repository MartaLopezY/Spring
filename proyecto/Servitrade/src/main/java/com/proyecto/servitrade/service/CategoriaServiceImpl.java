package com.proyecto.servitrade.service;



import com.proyecto.servitrade.entity.Categoria;
import com.proyecto.servitrade.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;


@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria agregar(Categoria categoria) { return categoriaRepository.save(categoria);}

    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerPorId(long id) throws NotFoundException {return categoriaRepository.findById(id).orElse(null);}

    public Categoria editar(Categoria categoria) throws NotFoundException { return categoriaRepository.save(categoria);}

    public void borrar(Long id) throws NotFoundException {categoriaRepository.deleteById(id);}
}

