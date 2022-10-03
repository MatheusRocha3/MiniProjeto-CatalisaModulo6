package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.EmbalagemRepository;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.dto.EmbalagemDto;
import com.miniprojeto.miniprojeto.dto.EmbalagemRespostaDto;
import com.miniprojeto.miniprojeto.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmbalagemService {

    private int pontosPorEmbalagem = 1500;
    @Autowired
    private EmbalagemRepository embalagemRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;


    public EmbalagemRespostaDto findByNumeroDeSerie(int numeroDeSerie) {
        Optional<EmbalagemModel> optionalEmbalagemModel = embalagemRepository.findByNumeroDeSerie(numeroDeSerie);
        if (optionalEmbalagemModel.isEmpty()) {
            throw new ObjectNotFoundException("A embalagem com o número de : " + numeroDeSerie + " não foi registrada,  tente outra.");
        }

        return EmbalagemRespostaDto.converterParaEmbalagemRespostaDto(optionalEmbalagemModel.get());
    }


    public EmbalagemRespostaDto cadastrar(EmbalagemDto embalagemDto, String cpf) {
        UsuarioModel usuarioEncontrado = usuarioService.pesquisarUsuarioPorCpf(cpf);
        Optional<EmbalagemModel> optionalEmbalagemModel = embalagemRepository.findByNumeroDeSerie(embalagemDto.getNumeroDeSerie());
        if (optionalEmbalagemModel.isPresent()) {
            throw new ObjectNotFoundException("A embalagem com o número de : " + embalagemDto.getNumeroDeSerie() + " já foi cadastrada, tente outra.");
        }
        embalagemDto.getNumeroDeSerie();
        EmbalagemModel embalagemModel = embalagemDto.converterParaEmbalagemModel();
        embalagemModel.setUsuario(usuarioEncontrado);
        usuarioService.adicionarPontos(usuarioEncontrado, pontosPorEmbalagem);
        EmbalagemModel embalagem = embalagemRepository.save(embalagemModel);
        return EmbalagemRespostaDto.converterParaEmbalagemRespostaDto(embalagem);
    }

}