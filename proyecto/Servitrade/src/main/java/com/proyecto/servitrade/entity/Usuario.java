package com.proyecto.servitrade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @JoinColumn(name="provincia")
    @ManyToOne
    private Provincia provincia;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private Long saldo;

    public Usuario(Long id,String nombre,String apellido, String email,String username,Provincia provincia,String password) {
        this.id=id;
        this.nombre = nombre;
        this.apellido=apellido;
        this.email=email;
        this.username=username;
        this.provincia=provincia;
        this.password=password;
        this.rol=Rol.USER;
        this.saldo=0L;

    }
}