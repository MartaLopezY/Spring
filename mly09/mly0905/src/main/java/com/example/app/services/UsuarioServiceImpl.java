package com.example.app.services;


import com.example.app.entity.Usuario;
import com.example.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    PasswordEncoder passwordEncoder;

    public Usuario agregar(Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return  usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id){return usuarioRepository.findById(id).orElse(null); }

    public Usuario editar (Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return  usuarioRepository.save(usuario);
    }
    public  void borrar (Long id) { usuarioRepository.deleteById(id);}
    public String obtenerUsuarioConectado(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return authentication.getName();
        }
        return null;
    }

    public String obtenerRolUsuarioConectado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().toString();
    }
public Usuario obtenerPorNombre(String nombre){return usuarioRepository.findByNombre(nombre);}

}
