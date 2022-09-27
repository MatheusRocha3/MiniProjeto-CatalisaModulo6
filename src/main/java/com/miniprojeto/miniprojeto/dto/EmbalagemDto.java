package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.enumeration.Estado;
import lombok.Getter;

@Getter
public class EmbalagemDto {
    private Estado estadoDeCadastro;
    private int numeroDeSerie;

    public EmbalagemModel transformarParaObjeto() {
        return new EmbalagemModel();
    }
}
