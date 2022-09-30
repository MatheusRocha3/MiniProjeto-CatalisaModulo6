package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioRespostaDto {
    private String nomeUsuario;
    private String email;
    private String cpf;
    private int totalPontos;


    public UsuarioRespostaDto(UsuarioModel usuarioModel) {

        this.nomeUsuario = usuarioModel.getNomeUsuario();
        this.email = usuarioModel.getEmail();
        this.cpf = usuarioModel.getCpf();
        this.totalPontos = usuarioModel.getTotalPontos();
    }

    public static UsuarioRespostaDto transformaEmDto(UsuarioModel usuarioModel) {
        return new UsuarioRespostaDto(usuarioModel.getNomeUsuario(), usuarioModel.getEmail(), usuarioModel.getCpf(), usuarioModel.getTotalPontos());
    }
}
