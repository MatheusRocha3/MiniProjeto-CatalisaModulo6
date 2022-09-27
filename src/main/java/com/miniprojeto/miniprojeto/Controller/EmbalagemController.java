package com.miniprojeto.miniprojeto.Controller;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Service.EmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/embalagem")
public class EmbalagemController {

    @Autowired
    private EmbalagemService embalagemService;

    @GetMapping(path = "/{id}")
    public Optional<EmbalagemModel> buscaId(@PathVariable Long id){
        return embalagemService.buscaIdEmbalagem(id);
    }



}
