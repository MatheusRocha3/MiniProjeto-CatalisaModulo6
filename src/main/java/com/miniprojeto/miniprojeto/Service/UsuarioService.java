package com.miniprojeto.miniprojeto.Service;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarTodos(){

        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarUsuarioId(Long id){

        return usuarioRepository.findById(id);
    }

    public UsuarioModel cadastraUsuario(UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alteraUsuario (UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public void deletaUsuario(Long id){

        usuarioRepository.deleteById(id);
    }
}
