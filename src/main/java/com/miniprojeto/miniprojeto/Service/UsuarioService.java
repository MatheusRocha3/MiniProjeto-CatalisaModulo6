package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.dto.UsuarioDto;
import com.miniprojeto.miniprojeto.dto.UsuarioRespostaDto;
import com.miniprojeto.miniprojeto.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarTodos() {

        return usuarioRepository.findAll();
    }

    protected UsuarioModel adicionarPontos(UsuarioModel usuarioModel, int pontosPorEmbalagem) {
        usuarioModel.setTotalPontos(usuarioModel.getTotalPontos() + pontosPorEmbalagem);
        return usuarioRepository.save(usuarioModel);
    }

    protected UsuarioModel pesquisarUsuarioPorCpf(String cpf) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(cpf);
        if (optionalUsuarioModel.isEmpty()) {
            throw new ObjectNotFoundException("O cpf com numeração de: " + cpf + " não foi cadastrado, tente outro. ");
        }
        return optionalUsuarioModel.get();
    }

    public UsuarioDto cadastraUsuario(UsuarioDto usuarioDto) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(usuarioDto.getCpf());
        if (optionalUsuarioModel.isPresent()) {
            throw new ObjectNotFoundException("este cpf já consta em nossa base de dados");
        }
        UsuarioModel usuarioModel = usuarioDto.converterParaUsuarioModel();
        usuarioRepository.save(usuarioModel);
        return usuarioDto;
    }

    public UsuarioRespostaDto alteraUsuario(UsuarioDto usuarioDto) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(usuarioDto.getCpf());
        if (optionalUsuarioModel.isEmpty()) {
            throw new ObjectNotFoundException("Não é possível atualizar este usuário, não há um cpf registrado com esta numeração.");
        }
        UsuarioModel usuarioModel = usuarioDto.converterParaUsuarioModel();
        UsuarioModel usuario = usuarioRepository.save(usuarioModel);
        return UsuarioRespostaDto.converterParaUsuarioRespostaDto(usuario);
    }


    public void deleteByCpf(String cpf) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(cpf);
        if (optionalUsuarioModel.isEmpty()) {
            throw new ObjectNotFoundException("este cpf não está registrado");
        }
        usuarioRepository.deleteByCpf(cpf);
    }

    public UsuarioRespostaDto findByCpf(String cpf) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(cpf);
        if (optionalUsuarioModel.isEmpty()) {
            throw new ObjectNotFoundException("não existe um usuário registrado com o cpf : " + cpf + ".");
        }


        return UsuarioRespostaDto.converterParaUsuarioRespostaDto(optionalUsuarioModel.get());
    }
}
