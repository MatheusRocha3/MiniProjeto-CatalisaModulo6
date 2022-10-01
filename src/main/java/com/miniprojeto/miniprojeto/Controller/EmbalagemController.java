package com.miniprojeto.miniprojeto.Controller;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Service.EmbalagemService;
import com.miniprojeto.miniprojeto.dto.EmbalagemDto;
import com.miniprojeto.miniprojeto.dto.EmbalagemRespostaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/embalagens")
public class EmbalagemController {

    @Autowired
    private EmbalagemService embalagemService;


    @PostMapping(path = "/{cpf}")
    public ResponseEntity<EmbalagemRespostaDto> cadastrarEmbalagem(@RequestBody @Valid EmbalagemDto dto, @PathVariable String cpf) {
        EmbalagemRespostaDto embalagem = embalagemService.cadastrar(dto, cpf);
        return new ResponseEntity<>(embalagem, HttpStatus.CREATED);
}

@GetMapping(path = "/{numerodeserie}")
public ResponseEntity<EmbalagemRespostaDto> findByNumeroDeSerie(@PathVariable int numeroDeSerie) {

EmbalagemRespostaDto embalagemRespostaDto = embalagemService.findByNumeroDeSerie(numeroDeSerie);
return ResponseEntity.ok(embalagemRespostaDto);
}
}
