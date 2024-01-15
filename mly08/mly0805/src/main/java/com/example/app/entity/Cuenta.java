package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "IBAN")
@Entity
public class Cuenta {

    @Id
    private String IBAN;
    private String alias;
    private Double saldo;
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Movimiento> movimientos;

}
