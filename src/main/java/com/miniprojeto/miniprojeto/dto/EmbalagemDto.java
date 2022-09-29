package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.enumeration.Estado;
import com.miniprojeto.miniprojeto.enumeration.Marca;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class EmbalagemDto {
    @NotBlank(message = "Estado é obrigatório")
    private Estado estadoDeCadastro;
    @NotNull(message = "numeração é obrigatória")
    private int numeroDeSerie;
    @NotBlank(message = "marca é obrigatória")
    private Marca marca;
    private UsuarioModel usuario;

    public EmbalagemModel transformarParaObjeto() {
        return new EmbalagemModel(estadoDeCadastro, numeroDeSerie, marca, usuario);
    }
}
