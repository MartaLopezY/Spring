package com.proyecto.servitrade.service;



import com.proyecto.servitrade.entity.Usuario;
import com.proyecto.servitrade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;


@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // PasswordEncoder passwordEncoder;
    public Usuario agregar(Usuario usuario) {
     /*   if(usuario.getPassword().length()>=4) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }*/
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorNombre(String username) throws NotFoundException {
        return usuarioRepository.findByUsername(username);
    }
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario editar(Usuario usuario) {
    /*    if(usuario.getPassword().length()>=4) {
            String passCrypted = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(passCrypted);
        }*/
        return usuarioRepository.save(usuario);
    }

    public void borrar(Long id)  { usuarioRepository.deleteById(id); }


}
