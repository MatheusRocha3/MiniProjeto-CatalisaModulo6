package com.miniprojeto.miniprojeto.Repository;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmbalagemRepository extends JpaRepository<EmbalagemModel, Long> {

}
