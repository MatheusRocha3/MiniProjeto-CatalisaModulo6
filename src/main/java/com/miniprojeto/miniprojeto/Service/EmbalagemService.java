package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.EmbalagemRepository;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmbalagemService {

    @Autowired
    private EmbalagemRepository embalagemRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<EmbalagemModel> buscaIdEmbalagem(Long id) {
        return embalagemRepository.findById(id);
    }

    public EmbalagemModel cadastrar(EmbalagemModel embalagemModel, String cpf) {

        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(cpf);
        if (optionalUsuarioModel.isEmpty()) {
            throw new ObjectNotFoundException("não existe um usuário cadastrado com este cpf");
        }
        UsuarioModel usuarioEncontrado = optionalUsuarioModel.get();
        embalagemModel.setUsuario(usuarioEncontrado);


        return embalagemRepository.save(embalagemModel);
    }
}