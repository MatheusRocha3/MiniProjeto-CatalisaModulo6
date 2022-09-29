package com.miniprojeto.miniprojeto.Repository;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    public Optional<UsuarioModel> findByCpf(String cpf);
    UsuarioModel deleteByCpf(String cpf);
}
