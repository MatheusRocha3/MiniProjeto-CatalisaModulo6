package com.miniprojeto.miniprojeto.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {
    @NotBlank(message = "nome é obrigatório")
    private String nomeUsuario;
@Email(message = "email é obrigatório")
    private String email;
@CPF(message = "cpf é obrigatório")
private String cpf;


}

