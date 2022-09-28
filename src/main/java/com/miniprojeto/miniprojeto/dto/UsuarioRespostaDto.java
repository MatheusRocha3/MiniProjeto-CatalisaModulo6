package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioRespostaDto {
    private String nomeUsuario;
    private String email;
    private String cpf;
    private int pontos;
    private LocalDate dataNascimento;

public static UsuarioRespostaDto transformaEmDto(UsuarioModel usuarioModel) {
    return new UsuarioRespostaDto(usuarioModel.getNomeUsuario(), usuarioModel.getEmail(), usuarioModel.getCpf(), usuarioModel.getPontos(), usuarioModel.getDataNascimento());
}
}
