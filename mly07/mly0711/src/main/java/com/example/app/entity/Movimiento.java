package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String IBAN;
    @Min(-300)
    @Max(1000)
    private Double importe;
    private LocalDateTime fecha;

    @ManyToOne
    private Cuenta cuenta;
    public Movimiento(String iban,LocalDateTime fecha) {
        this.IBAN=iban;
        this.fecha=fecha;
    }
}
