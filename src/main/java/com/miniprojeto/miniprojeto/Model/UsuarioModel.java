package com.miniprojeto.miniprojeto.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarioss")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;



    @Column(name = "nome_usuario", length = 30)
    private String nomeUsuario;


    @Column( name = "email_usuario", length = 30)
    private String email;


    @Column( name=  "cpf_usuario", length = 11)
    private String cpf;


    @Column(name = "pontos")
    private int pontos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<EmbalagemModel> embalagens;

    public UsuarioModel(String nomeUsuario, String email, String cpf) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;

    }
    public UsuarioModel(Long id, String nomeUsuario, String email, String cpf) {

    }
}



