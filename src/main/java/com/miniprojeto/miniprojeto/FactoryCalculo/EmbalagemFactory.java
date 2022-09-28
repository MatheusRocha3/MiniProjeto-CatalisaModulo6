package com.miniprojeto.miniprojeto.FactoryCalculo;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;

import java.math.BigDecimal;

public interface EmbalagemFactory {

    public BigDecimal calcularEmbalagens(EmbalagemModel embalagemModel);
}
