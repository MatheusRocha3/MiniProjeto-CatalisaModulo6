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

    private static final int PONTOS_POR_EMBALAGEM = 1500;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarTodos(){

        return usuarioRepository.findAll();
    }

    public Optional<UsuarioDto> buscarUsuarioId(Long id){
        final Optional<UsuarioModel> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            final UsuarioModel usuarioDb = opt.get();
            int totalPontos = usuarioDb.getEmbalagens().size() * PONTOS_POR_EMBALAGEM;
            final var dto =  new UsuarioDto(usuarioDb.getNomeUsuario(),usuarioDb.getCpf(),usuarioDb.getEmail(),totalPontos);
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    public UsuarioModel cadastraUsuario(UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alteraUsuario (UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public void deletaUsuario(Long id){
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
