package com.miniprojeto.miniprojeto.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


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

    @Column(unique = true, name = "email-usuario", length = 30, nullable = false)
    private String email;

    @Column(unique = true, name=  "cpf-usuario", length = 11, nullable = false)
    private String cpf;

    @Column(name = "data-de-nascimento", length = 15, nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "pontos", nullable = false)
    private int pontos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<EmbalagemModel> embalagens;

    public UsuarioModel(String nomeUsuario, String email, String cpf, LocalDate dataNascimento) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
}
