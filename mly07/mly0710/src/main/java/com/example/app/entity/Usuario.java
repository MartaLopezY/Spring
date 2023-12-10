package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String nombre;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaCreacion=LocalDate.now();

}
