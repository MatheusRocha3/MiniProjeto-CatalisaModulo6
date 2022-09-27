package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.enumeration.Estado;
import com.miniprojeto.miniprojeto.enumeration.Marca;
import lombok.Getter;

@Getter
public class EmbalagemDto {
private Estado estadoDeCadastro;
private int numeroDeSerie;
private Marca marca;

public EmbalagemModel transformarParaObjeto() {
    return new EmbalagemModel();
}
}
