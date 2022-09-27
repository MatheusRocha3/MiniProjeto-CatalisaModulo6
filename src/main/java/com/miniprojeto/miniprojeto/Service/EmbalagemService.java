package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Repository.EmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmbalagemService {

    @Autowired
    private EmbalagemRepository embalagemRepository;

    public Optional<EmbalagemModel> buscaIdEmbalagem(Long id) {
        return embalagemRepository.findById(id);
    }

    public EmbalagemModel cadastrar(EmbalagemModel embalagemModel) {
    return embalagemRepository.save(embalagemModel);
    }
}
