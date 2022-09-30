package com.miniprojeto.miniprojeto.Controller;


import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import com.miniprojeto.miniprojeto.Repository.UsuarioRepository;
import com.miniprojeto.miniprojeto.Service.UsuarioService;
import com.miniprojeto.miniprojeto.dto.UsuarioDto;
import com.miniprojeto.miniprojeto.dto.UsuarioRespostaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> buscarTudo() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }


    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody @Valid UsuarioDto dto) {
         UsuarioDto usuario = usuarioService.cadastraUsuario(dto);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }


    @GetMapping(path = "/cpf/{cpf}")
    public ResponseEntity<Optional<UsuarioModel>> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(usuarioRepository.findByCpf(cpf));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterarCadUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.alteraUsuario(usuarioModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletaUsuario(id);
    }

    @DeleteMapping(path = "/deletebycpf/{cpf}")
    public void deletarUsuarioPorCpf(@PathVariable String cpf) {
        usuarioService.deleteByCpf(cpf);
    }
}
