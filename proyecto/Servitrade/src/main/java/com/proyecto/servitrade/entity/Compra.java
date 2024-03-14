package com.proyecto.servitrade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compra {
    public Compra(LocalDateTime creacionDate, Usuario usuario) {
        this.creacionDate = creacionDate;
        this.usuario=usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creacionDate;
    @ManyToOne
    private  Usuario usuario;


}
