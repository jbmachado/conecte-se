package br.edu.ifrs.restinga.conectese.usuario.controller;

import br.edu.ifrs.restinga.conectese.usuario.model.Usuario;
import br.edu.ifrs.restinga.conectese.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping(value = "/usuario")
public class UsuarioRestController {
    
    private final UsuarioService service;
    
    @PostMapping(value = "/salvar")
    public ResponseEntity<?> salvarUsuario(
        @RequestBody
        @Validated
        Usuario usuario) {
        return service.salvarUsuario(usuario);
    }
    
    @PatchMapping(value = "/alterarperfil")
    public ResponseEntity<?> salvarUsuario(
        @RequestParam Integer idUsuario,
        @RequestParam Integer idPerfil) {
        return service.alterarPerfil(idUsuario, idPerfil);
    }
}
