package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Repository.EmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
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
