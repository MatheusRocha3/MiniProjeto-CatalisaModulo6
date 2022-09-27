package com.miniprojeto.miniprojeto.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome-usuario", length = 30, nullable = false)
    private String nomeUsuario;

    @Column(name = "email-usuario", length = 30, nullable = false)
    private String email;

    @Column(name = "cpf-usuario", length = 11, nullable = false)
    private String cpf;
}
