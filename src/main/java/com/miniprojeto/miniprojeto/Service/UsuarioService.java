package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.dto.UsuarioDto;
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

    public UsuarioModel adicionarPontos(UsuarioModel usuarioModel) {

        int totalPontos = usuarioModel.getEmbalagens().size() * 1500;
        usuarioModel.setTotalPontos(totalPontos);
        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioDto cadastraUsuario(UsuarioDto usuarioDto) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(usuarioDto.getCpf());
        if (optionalUsuarioModel.isPresent()) {
            throw new ObjectNotFoundException("este cpf já consta em nossa base de dados");
        }
        UsuarioModel usuarioModel = usuarioDto.transformaParaObjeto();
        usuarioRepository.save(usuarioModel);
        return usuarioDto;
    }

    public UsuarioModel alteraUsuario(UsuarioModel usuarioModel) {

        return usuarioRepository.save(usuarioModel);
    }

    public void deletaUsuario(Long id) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findById(id);
        if (optionalUsuarioModel.isEmpty()) {
            throw new ObjectNotFoundException("não foi encontrado um usuário com este registro em nossa base de dados");
        }
        usuarioRepository.deleteById(id);
    }

    public void deleteByCpf(String cpf) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(cpf);
        if (optionalUsuarioModel.isEmpty()) {
            throw new ObjectNotFoundException("este cpf não está registrado");
        }
        usuarioRepository.deleteByCpf(cpf);
    }

    public UsuarioModel findByCpf(String cpf) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByCpf(cpf);
        if (optionalUsuarioModel.isEmpty()) {
            throw new ObjectNotFoundException("não existe");
        }

        return optionalUsuarioModel.get();
    }
}
