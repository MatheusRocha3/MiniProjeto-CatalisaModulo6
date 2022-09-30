package com.miniprojeto.miniprojeto.Model;

import com.miniprojeto.miniprojeto.enumeration.Estado;
import com.miniprojeto.miniprojeto.enumeration.Marca;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "embalagens")
public class EmbalagemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estado_de_cadastro", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estadoDeCadastro;

    @Column(length = 5, nullable = false, unique = true)
    private int numeroDeSerie;
    @Enumerated(EnumType.STRING)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;

    public EmbalagemModel(Estado estadoDeCadastro, int numeroDeSerie, Marca marca, UsuarioModel usuario) {
        this.estadoDeCadastro = estadoDeCadastro;
        this.numeroDeSerie = numeroDeSerie;
        this.marca = marca;
        this.usuario = usuario;
    }
}
