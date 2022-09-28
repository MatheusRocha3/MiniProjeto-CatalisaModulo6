package com.miniprojeto.miniprojeto.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miniprojeto.miniprojeto.dto.UsuarioDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarioss")
public class UsuarioModel {
    @Id
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

}



