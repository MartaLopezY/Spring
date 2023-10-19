package com.example.app.entity;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triangulo {
    @NotNull
    @Min(0)
    Integer cateto1;
    @NotNull
    @Min(0)
    Integer cateto2;
}
