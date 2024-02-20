package com.example.app.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmpleadoDto {
    @NotNull
    @Min(1)
    private Long id;

    @Email
    private String email;


}