package com.example.app.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movimiento {
    @NotNull
    @Min(1)
    private Long id;
    private String IBAN;
    @Min(-300)
    @Max(1000)
    private Double importe;
    private LocalDateTime fecha;


    public Movimiento(String iban,LocalDateTime fecha) {
        this.IBAN=iban;
        this.fecha=fecha;
    }
}
