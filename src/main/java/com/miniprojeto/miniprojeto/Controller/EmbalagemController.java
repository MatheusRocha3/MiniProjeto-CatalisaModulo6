package com.miniprojeto.miniprojeto.Controller;

import com.miniprojeto.miniprojeto.Model.EmbalagemModel;
import com.miniprojeto.miniprojeto.Model.UsuarioModel;
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
@RequestMapping(path = "/embalagem")
public class EmbalagemController {

    @Autowired
    private EmbalagemService embalagemService;

    @GetMapping(path = "/{id}")
    public Optional<EmbalagemModel> buscaId(@PathVariable Long id){
        return embalagemService.buscaIdEmbalagem(id);
    }
    @PostMapping(path = "/{cpf}")
    public ResponseEntity<EmbalagemRespostaDto> cadastrarEmbalagem(@RequestBody @Valid EmbalagemDto dto, @PathVariable String cpf) {
        EmbalagemModel embalagem  = embalagemService.cadastrar(dto.transformarParaObjeto(), cpf);
        return new ResponseEntity<>(EmbalagemRespostaDto.transformaEmbDto(embalagem), HttpStatus.CREATED);
}


}
