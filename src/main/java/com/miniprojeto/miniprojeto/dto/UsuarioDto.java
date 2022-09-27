package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Getter
public class UsuarioDto {
    @NotBlank(message = "nome é obrigatório")
    private String nomeUsuario;
    @NotBlank(message = "cpf é obrigatório")
    @CPF(message = "cpf é obrigatório")
    private String cpf;
    @NotBlank(message = "email é obrigatório")
    @Email
    private String email;

    public UsuarioModel transformaParaObjeto() {
        return new UsuarioModel();
    }
}

