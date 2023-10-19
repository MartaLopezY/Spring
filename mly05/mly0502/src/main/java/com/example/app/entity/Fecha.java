package com.example.app.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fecha {
    @NotNull
    String fecha1;
    @NotNull

    String fecha2;
    @NotNull
    Boolean tipo;

}
