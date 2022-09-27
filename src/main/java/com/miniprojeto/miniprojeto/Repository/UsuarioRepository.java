package com.miniprojeto.miniprojeto.Repository;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>  {
}
