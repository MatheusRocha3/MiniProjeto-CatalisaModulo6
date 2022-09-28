package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.enumeration.Estado;
import com.miniprojeto.miniprojeto.enumeration.Marca;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter

public class EmbalagemRespostaDto {

    private Estado estadoDeCadastro;

    private int numeroDeSerie;

    private Marca marca;

    public EmbalagemRespostaDto(EmbalagemModel embalagemModel) {
        this.estadoDeCadastro = embalagemModel.getEstadoDeCadastro();
        this.numeroDeSerie = embalagemModel.getNumeroDeSerie();
        this.marca = embalagemModel.getMarca();
    }

    public static EmbalagemRespostaDto transformaEmbDto(EmbalagemModel embalagemModel){
        return new EmbalagemRespostaDto(embalagemModel.getEstadoDeCadastro(), embalagemModel.getNumeroDeSerie(), embalagemModel.getMarca());
    }
}
