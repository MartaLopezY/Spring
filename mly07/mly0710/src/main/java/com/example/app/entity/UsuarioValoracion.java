package com.example.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class UsuarioValoracion implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "valoracion_id")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Valoracion  valoracion;

}
