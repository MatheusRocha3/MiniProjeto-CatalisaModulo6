package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.enumeration.Estado;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class EmbalagemDto {
    @NotBlank(message = "Estado é obrigatório")
    private Estado estadoDeCadastro;
    @NotNull(message = "numeração é obrigatória")
    private int numeroDeSerie;

    public EmbalagemModel transformarParaObjeto() {
        return new EmbalagemModel();
    }
}
