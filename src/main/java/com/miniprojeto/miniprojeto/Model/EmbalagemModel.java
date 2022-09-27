package com.miniprojeto.miniprojeto.Model;

import com.miniprojeto.miniprojeto.enumeration.Estado;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "embalagens")
public class EmbalagemModel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "estado_de_cadastro", length = 20, nullable = false)
    private Estado EstadoDeCadastro;
    @Column(length = 5, nullable = false)
    private int numeroDeSerie;
    @Column(name = "marca", nullable = false)
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;

    public EmbalagemModel(Estado estadoDeCadastro, int numeroDeSerie) {
        this.EstadoDeCadastro = estadoDeCadastro;
        this.numeroDeSerie = numeroDeSerie;
    }
}
